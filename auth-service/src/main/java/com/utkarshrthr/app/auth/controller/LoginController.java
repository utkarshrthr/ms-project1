package com.utkarshrthr.app.auth.controller;

import com.utkarshrthr.app.auth.dto.AuthRequest;
import com.utkarshrthr.app.auth.dto.AuthResponse;
import com.utkarshrthr.app.auth.service.LoginService;
import com.utkarshrthr.app.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid AuthRequest authRequest) {
        AuthResponse response = loginService.login(authRequest);
        return ApiResponse.getResponse(HttpStatus.OK, response);
    }
}