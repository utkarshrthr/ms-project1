package com.utkarshrthr.app.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Optional;

@Component
public class Auditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return Optional.of(principal.getName());
    }
}
