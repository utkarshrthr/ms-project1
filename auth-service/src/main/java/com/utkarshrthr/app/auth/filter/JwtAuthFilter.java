package com.utkarshrthr.app.auth.filter;

import com.utkarshrthr.app.auth.service.JwtAuthService;
import com.utkarshrthr.app.exception.AuthenticationException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.stream.Stream;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private static final String[] bypassURLs = {
            "/login", "/user/**", "/role/**", "/actuator/**" // TODO -> Move these to configuration file
    };

    private final JwtAuthService jwtAuthService;

    private static final AntPathMatcher pathMatcher = new AntPathMatcher();

    public JwtAuthFilter(JwtAuthService jwtAuthService) {
        this.jwtAuthService = jwtAuthService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(header == null || !header.startsWith("Bearer ")){
            throw new AuthenticationException("Missing authentication token.");
        }
        final String token = header.substring(7);
        if(jwtAuthService.isTokenValid(token)){
            jwtAuthService.updateSecurityContext(token);
        }
        filterChain.doFilter(request, response);
    }

    // FilterChain is an example of `Chain-of-Responsibility` design pattern.

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return Stream
                .of(bypassURLs)
                .anyMatch(path -> pathMatcher.match(path, request.getServletPath()));
    }
}
