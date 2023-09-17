package com.utkarshrthr.app.auth.util;

import java.security.Principal;

public class AppPrincipal implements Principal {

    private final String name;

    public AppPrincipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
