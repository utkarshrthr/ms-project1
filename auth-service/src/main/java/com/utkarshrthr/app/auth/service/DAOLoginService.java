package com.utkarshrthr.app.auth.service;

import com.utkarshrthr.app.auth.dto.AuthRequest;
import com.utkarshrthr.app.auth.dto.AuthResponse;
import org.springframework.stereotype.Service;

@Service
public class DAOLoginService implements LoginService {

    private final AuthService authService;

    public DAOLoginService(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        return authService.authenticate(request.getUsername(), request.getPassword());
    }
}
