package com.utkarshrthr.app.user.controller;

import com.utkarshrthr.app.user.dto.UserRequest;
import com.utkarshrthr.app.user.dto.UserResponse;
import com.utkarshrthr.app.user.service.UserService;
import com.utkarshrthr.app.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserRequest request){
        String message = service.createUser(request);
        return ApiResponse.getResponse(HttpStatus.CREATED, message);
    }

    @PutMapping("{username}")
    public ResponseEntity<Object> updateUser(@RequestBody @Valid UserRequest request, @PathVariable String username){
        String message = service.updateUser(request);
        return ApiResponse.getResponse(HttpStatus.OK, message);
    }

    @GetMapping("{username}")
    public ResponseEntity<Object> getUser(@PathVariable String username){
        UserResponse user = service.getUser(username);
        return ApiResponse.getResponse(HttpStatus.OK, user);
    }

    @GetMapping
    public ResponseEntity<Object> getAllUser(){
        List<UserResponse> users = service.getAllUsers();
        return ApiResponse.getResponse(HttpStatus.OK, users);
    }

    @GetMapping("search")
    public ResponseEntity<Object> searchUser(@RequestParam String query){
        List<UserResponse> users = service.searchUsers(query);
        return ApiResponse.getResponse(HttpStatus.OK, users);
    }

    @DeleteMapping("{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable String username){
        String message = service.deleteUser(username);
        return ApiResponse.getResponse(HttpStatus.OK, message);
    }
}
