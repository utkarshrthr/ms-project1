package com.utkarshrthr.app.config;

import com.utkarshrthr.app.auth.service.DAOLoginService;
import com.utkarshrthr.app.auth.service.LDAPLoginService;
import com.utkarshrthr.app.auth.service.LoginService;
import com.utkarshrthr.app.filter.JwtAuthFilter;
import com.utkarshrthr.app.user.service.DAOUserService;
import com.utkarshrthr.app.user.service.LDAPUserService;
import com.utkarshrthr.app.user.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeanConfig {

    @Value("${app.auth-type}")
    private String authType;

    @Bean
    public UserService userService(){
        switch (authType){
            case "LDAP":
                return new LDAPUserService();
            case "DAO":
                return new DAOUserService();
            default:
                throw new IllegalStateException();
        }
    }

    @Bean
    public LoginService loginService(){
        switch (authType){
            case "LDAP":
                return new LDAPLoginService();
            case "DAO":
                return new DAOLoginService();
            default:
                throw new IllegalStateException();
        }
    }

    @Bean
    public FilterRegistrationBean<JwtAuthFilter> jwtAuthFilter() {
        FilterRegistrationBean<JwtAuthFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtAuthFilter());
        registrationBean.setEnabled(false);
        return registrationBean;
    }
}
