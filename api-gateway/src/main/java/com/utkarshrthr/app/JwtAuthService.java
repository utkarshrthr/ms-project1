package com.utkarshrthr.app;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JwtAuthService {

    // TODO -> generate secret using https://acte.ltd/utils/randomkeygen
    // TODO -> Move these to configuration file other than application.properties
    private static final String JWT_SECRET = "s3cr3t";
    private static final String ROLES = "ROLES";
    private static final long VALIDITY = 1800;


    private Algorithm getJwtAlgorithm(String secret) {
        return Algorithm.HMAC256(secret);
    }


    public String generateToken(String username, List<String> roles){
        return generateToken(username, roles, VALIDITY, JWT_SECRET);
    }

    private String generateToken(String username, List<String> roles, long validity, String secret){
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + validity * 1000))
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withClaim(ROLES, roles)
                .sign(getJwtAlgorithm(secret));
    }

    public boolean isTokenValid(String token){
        try {
            JWTVerifier jwtVerifier = JWT.require(getJwtAlgorithm(JWT_SECRET)).build();
            jwtVerifier.verify(token);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
