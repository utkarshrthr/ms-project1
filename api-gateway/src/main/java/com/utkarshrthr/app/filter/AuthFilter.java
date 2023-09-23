package com.utkarshrthr.app.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    public AuthFilter() {
        super(Config.class);
    }


    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            List<String> authHeaders = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);

            if(CollectionUtils.isEmpty(authHeaders))
                throw new RuntimeException("Missing auth token");

            String token = authHeaders.get(0);

            if(token != null && token.startsWith("Bearer ")){

                token = token.substring(7);
                // TODO -> Validate token
            }
            else {
               //  throw new RuntimeException("Missing auth token");
            }
            exchange.getResponse().setRawStatusCode(HttpStatus.UNAUTHORIZED.value());
            return chain.filter(exchange);
        });
    }

    public static class Config {

    }
}
