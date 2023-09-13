package com.utkarshrthr.app.auth.service;

import com.utkarshrthr.app.auth.dto.AuthRequest;
import com.utkarshrthr.app.auth.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DAOLoginService implements LoginService {

    @Autowired
    private AuthService authService;

    @Override
    public AuthResponse login(AuthRequest request) {
        return authService.authenticate(request.getUsername(), request.getPassword());
    }
}
