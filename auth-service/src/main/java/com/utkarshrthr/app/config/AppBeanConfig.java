package com.utkarshrthr.app.config;

import com.utkarshrthr.app.auth.service.AuthService;
import com.utkarshrthr.app.auth.service.DAOLoginService;
import com.utkarshrthr.app.auth.service.LDAPLoginService;
import com.utkarshrthr.app.auth.service.LoginService;
import com.utkarshrthr.app.user.service.DAOUserService;
import com.utkarshrthr.app.user.service.LDAPUserService;
import com.utkarshrthr.app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class AppBeanConfig {

    @Value("${app.auth-type}")
    private String authType;

    @Autowired
    private AuthService authService;

    /* private final AuthService authService;
    public AppBeanConfig(AuthService authService) {
        this.authService = authService;
    }*/

    @Bean
    public UserService userService(){
        return switch (authType) { // Enhanced Switch
            case "LDAP" -> new LDAPUserService();
            case "DAO" -> new DAOUserService();
            default -> throw new IllegalStateException();
        };
    }

    @Bean
    public LoginService loginService(){
        switch (authType){
            case "LDAP":
                return new LDAPLoginService(authService);
            case "DAO":
                return new DAOLoginService(authService);
            default:
                throw new IllegalStateException();
        }
    }

    @Bean
    public LocaleResolver localeResolver(){
        //SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        return messageSource;
    }

    /*@Bean
    public FilterRegistrationBean<JwtAuthFilter> jwtAuthFilter() {
        FilterRegistrationBean<JwtAuthFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtAuthFilter(jwtAuthService));
        registrationBean.setEnabled(false);
        return registrationBean;
    }*/
}
