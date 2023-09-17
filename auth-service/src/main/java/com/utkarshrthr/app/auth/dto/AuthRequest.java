package com.utkarshrthr.app.auth.dto;

import jakarta.validation.constraints.NotEmpty;

// TODO -> finalize scope for DTOs,
public class AuthRequest {

    @NotEmpty(message = "username can not be null or empty")
    private String username;

    // TODO -> Enable multiple annotation in ordered manner, 1. NotEmpty, 2. Pattern
    @NotEmpty(message = "password can not be null or empty")
    // TODO -> Pattern used in below annotation is not working
    //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}$", message = "Password must contain minimum 8 characters, 1 upper-case letter, 1 lower-case letter, 1 special-character(@ $ ! % * ? &) and one number")
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
