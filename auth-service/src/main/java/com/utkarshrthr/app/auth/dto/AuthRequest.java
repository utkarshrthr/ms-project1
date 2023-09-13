package com.utkarshrthr.app.auth.dto;

import jakarta.validation.constraints.NotEmpty;

// TODO -> finalize scope for DTOs,
public class AuthRequest {

    @NotEmpty(message = "username can not be null or empty")
    private String username;
    @NotEmpty(message = "password can not be null or empty")

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
