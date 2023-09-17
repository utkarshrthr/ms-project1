package com.utkarshrthr.app.user.service;

import com.utkarshrthr.app.user.dto.UserRequest;
import com.utkarshrthr.app.user.dto.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    String createUser(UserRequest request);

    String updateUser(UserRequest request);

    String deleteUser(String username);

    UserResponse getUserById(String id);

    UserResponse getUserByUsername(String id);

    List<UserResponse> getAllUsers();

    List<UserResponse> searchUsers(String query);
}
