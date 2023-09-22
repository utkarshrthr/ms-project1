package com.utkarshrthr.app;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    private final RestTemplateBuilder builder;

    public AppConfig(RestTemplateBuilder builder) {
        this.builder = builder;
    }


    @Bean
    public RestTemplate restTemplate(){
        // return builder.build();
        return new RestTemplate();
    }
}
