package com.utkarshrthr.app.user.service;

import com.utkarshrthr.app.user.dto.UserRequest;
import com.utkarshrthr.app.user.dto.UserResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class LDAPUserService implements UserService {

    @Override
    public String createUser(UserRequest request) {
        return "User record created successfully.";
    }

    @Override
    public String updateUser(UserRequest request) {
        return "User record updated successfully.";
    }

    @Override
    public String deleteUser(String username) {
        return "User record deleted successfully.";
    }

    @Override
    public UserResponse getUser(String id) {
        return null;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return null;
    }

    @Override
    public List<UserResponse> searchUsers(String query) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
