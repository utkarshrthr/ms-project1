package com.utkarshrthr.app.filter;

import com.utkarshrthr.app.JwtAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    public AuthFilter() {
        super(Config.class);
    }

    @Autowired
    private JwtAuthService authService;

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            List<String> authHeaders = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);

            if(CollectionUtils.isEmpty(authHeaders) || !(authHeaders.get(0) != null && authHeaders.get(0).startsWith("Bearer "))){
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();

            }
            String token = authHeaders.get(0).substring(7);
            if(authService.isTokenValid(token)){
                return chain.filter(exchange);
            }
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        });
    }

    public static class Config {

    }
}
