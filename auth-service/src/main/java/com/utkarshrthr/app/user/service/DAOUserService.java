package com.utkarshrthr.app.user.service;

import com.utkarshrthr.app.exception.UserNotFoundException;
import com.utkarshrthr.app.user.dto.UserRequest;
import com.utkarshrthr.app.user.dto.UserResponse;
import com.utkarshrthr.app.user.entity.DAOUser;
import com.utkarshrthr.app.user.repository.AppUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DAOUserService implements UserService {

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public String createUser(UserRequest request) {
        // TODO -> Add logic to validate roles existence
        DAOUser user = new DAOUser();
        BeanUtils.copyProperties(request, user);

        Set<String> roles = request.getRoles();



        // TODO -> Handle logic to add `AppRole` to `AppUser` object
        userRepository.save(user);
        return "User record created successfully";
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
    public UserResponse getUser(String id) {
        DAOUser user = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(""));
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(user, response);
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
        //return userRepository.findById(username).get();
        DAOUser user = new DAOUser();
        user.setUsername("Utkarsh");
        user.setPassword("rathore");
        user.setActive(true);
        return user;
    }
}