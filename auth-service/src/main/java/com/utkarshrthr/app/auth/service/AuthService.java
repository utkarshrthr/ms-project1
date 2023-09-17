package com.utkarshrthr.app.auth.service;

import com.utkarshrthr.app.auth.dto.AuthResponse;
import com.utkarshrthr.app.exception.AuthenticationException;
import com.utkarshrthr.app.user.dto.UserResponse;
import com.utkarshrthr.app.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final AuthenticationManager manager;
    private final UserService service;
    private final JwtAuthService authService;

    public AuthService(AuthenticationManager manager, UserService service, JwtAuthService authService) {
        this.manager = manager;
        this.service = service;
        this.authService = authService;
    }

    public AuthResponse authenticate(String username, String password){
        try {
            Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            if (authentication.isAuthenticated()){
                List<String> roles = authentication
                        .getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());
                return generateAuthResponse(username, roles);
            }
            throw new AuthenticationException("");
        }
        catch(org.springframework.security.core.AuthenticationException ex){
            throw new AuthenticationException(ex.getMessage());
        }
    }

    private AuthResponse generateAuthResponse(String username, List<String> roles ){
        AuthResponse authResponse = new AuthResponse();
        UserResponse userResponse = service.getUserById(username);
        BeanUtils.copyProperties(userResponse, authResponse);
        String token = authService.generateToken(username, roles);
        authResponse.setToken(token);
        return authResponse;
    }
}
