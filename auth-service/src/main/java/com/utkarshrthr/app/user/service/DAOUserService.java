package com.utkarshrthr.app.user.service;

import com.utkarshrthr.app.exception.UserNotFoundException;
import com.utkarshrthr.app.user.dto.UserRequest;
import com.utkarshrthr.app.user.dto.UserResponse;
import com.utkarshrthr.app.user.entity.DAORole;
import com.utkarshrthr.app.user.entity.DAOUser;
import com.utkarshrthr.app.user.repository.DAOUserRepository;
import com.utkarshrthr.app.user.repository.DaoRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class DAOUserService implements UserService {

    @Autowired
    private DAOUserRepository userRepository;

    @Autowired
    private DaoRoleRepository roleRepository;

    @Override
    public String createUser(UserRequest request) {
        // TODO -> Add logic to validate roles existence
        DAOUser user = new DAOUser();
        BeanUtils.copyProperties(request, user);
        List<DAORole> roles = roleRepository.findAllById(request.getRoles());
        user.setRoles(roles);
        DAOUser newUser = userRepository.save(user);
        return "User record with id: "+ newUser.getId() +" created successfully";
    }

    @Override
    public String updateUser(UserRequest request) {
        // TODO -> Handle logic to update username & email, should throw 400-Bad-Request if username & email already exist for some other user
        DAOUser user = userRepository
                .findById(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException(""));
        BeanUtils.copyProperties(request, user);
        userRepository.save(user);
        return "User record updated successfully.";
    }

    @Override
    public String deleteUser(String username) {
        userRepository.deleteById(username);
        return "User record deleted successfully.";
    }

    @Override
    public UserResponse getUserById(String id) {
        DAOUser user = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(""));
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(user, response);
        List<String> roles = getNamesFromDAORoles(user.getRoles());
        response.setRoles(roles);
        return response;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserResponse> users = new ArrayList<>();
        userRepository
            .findAll()
            .forEach(user -> {
                UserResponse response = new UserResponse();
                BeanUtils.copyProperties(user, response);
                List<String> roles = getNamesFromDAORoles(user.getRoles());
                response.setRoles(roles);
                users.add(response);
            });
        // TODO -> API should return 204-No-Content if no records found
        return users;
    }

    @Override
    public List<UserResponse> searchUsers(String query) {
        // TODO -> Users can be searched by username, email & title
        // TODO -> API should return 204-No-Content if no records found
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<DAOUser> users = userRepository.findDAOUserByUsername(username);
        if(CollectionUtils.isEmpty(users))
            throw new UsernameNotFoundException("");
        return users.get(0);
    }

    private List<String> getNamesFromDAORoles(List<DAORole> roles){
        return roles
                .stream()
                .map(role -> role.getName())
                .toList();
    }
}
