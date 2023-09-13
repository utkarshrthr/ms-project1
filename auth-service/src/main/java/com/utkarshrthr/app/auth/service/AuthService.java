package com.utkarshrthr.app.auth.service;

import com.utkarshrthr.app.auth.dto.AuthResponse;
import com.utkarshrthr.app.exception.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager manager;

    public AuthResponse authenticate(String username, String password){
        try {
            Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            if (authentication.isAuthenticated()){
                List<String> roles = authentication
                        .getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());

                authentication.getDetails();
            }
        }
        catch(AuthenticationException ex){
            throw new AuthException(ex.getMessage());
        }
        return new AuthResponse();
    }
}
