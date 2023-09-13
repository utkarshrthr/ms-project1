package com.utkarshrthr.app.filter;

import com.utkarshrthr.app.auth.service.JwtAuthService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.stream.Stream;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private static final String AUTH_HEADER = "Authorization";

    @Autowired
    private JwtAuthService authService;

    private static final AntPathMatcher pathMatcher = new AntPathMatcher();

    private static final String[] bypassURLs = {
            "/login", "/user/**", "/role/**"
    };

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String header = request.getHeader(AUTH_HEADER);
        if(header == null || !header.startsWith("Bearer ")){
            // TODO -> throw custom Authentication exception
        }
        final String token = header.substring(7);

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
