package com.utkarshrthr.app.auth.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

// TODO -> finalize scope for DTOs
@Getter
@Setter
public class AuthRequest {

    @NotEmpty(message = "username can not be null or empty")
    private String username;

    // TODO -> Enable multiple annotation in ordered manner, 1. NotEmpty, 2. Pattern
    @NotEmpty(message = "password can not be null or empty")
    // TODO -> Pattern used in below annotation is not working
    //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}$", message = "Password must contain minimum 8 characters, 1 upper-case letter, 1 lower-case letter, 1 special-character(@ $ ! % * ? &) and one number")
    private String password;
}
