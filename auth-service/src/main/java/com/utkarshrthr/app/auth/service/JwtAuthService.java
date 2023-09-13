package com.utkarshrthr.app.auth.service;

import org.springframework.stereotype.Service;

@Service
public class JwtAuthService {

    private static final String JWT_SECRET = "";
    // TODO -> generate secret using https://acte.ltd/utils/randomkeygen

    public boolean isTokenValid(String token){
        // TODO -> throw custom exception if token is expired|invalid
        return true;
    }

    public String extractUsernameFromToken(String token){
        return null;
    }
}
