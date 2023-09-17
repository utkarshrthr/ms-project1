package com.utkarshrthr.app.auth.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.utkarshrthr.app.exception.AuthenticationException;
import com.utkarshrthr.app.user.entity.DAOUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        catch (SignatureVerificationException ex) {
            throw new AuthenticationException("Invalid token");
        }
        catch (TokenExpiredException e){
            throw new AuthenticationException("Expired token");
        }
        catch (Exception e){
            throw new AuthenticationException(e.getMessage());
        }
    }

    public void updateSecurityContext(String token){
        String userName = JWT.decode(token).getSubject();
        DAOUser user = new DAOUser();
        user.setUsername(userName);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, getAuthoritiesFromToken(token));

        // Principal principal = new AppPrincipal(userName);
        // UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(principal, null, getAuthoritiesFromToken(token));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private List<SimpleGrantedAuthority> getAuthoritiesFromToken(String token) {
        List<String> roles = JWT
                .decode(token)
                .getClaim(ROLES)
                .asList(String.class);

        return roles
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
