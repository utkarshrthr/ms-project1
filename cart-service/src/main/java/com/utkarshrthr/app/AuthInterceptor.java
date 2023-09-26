package com.utkarshrthr.app;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class AuthInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER="Authorization";
    private static final String TOKEN_TYPE = "Bearer";

    @Override
    public void apply(RequestTemplate template) {
        if(CollectionUtils.isEmpty(template.headers())){
            template.headers().computeIfPresent(HttpHeaders.AUTHORIZATION, (s, values) ->{
                template.header(HttpHeaders.AUTHORIZATION, values);
                return values;
            });
        }
    }
}
