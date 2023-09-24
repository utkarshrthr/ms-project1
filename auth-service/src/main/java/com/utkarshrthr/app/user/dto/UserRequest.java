package com.utkarshrthr.app.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {

    @NotEmpty(message = "username can not be null or empty")
    private String username;

    @NotEmpty(message = "First name can not be null or empty")
    private String firstName;

    @NotEmpty(message = "last name can not be null or empty")
    private String lastName;

    @NotEmpty(message = "username can not be null or empty")
    private String title; // TODO -> title need to be validated against a set of values

    //@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Invalid email format.")
    @NotEmpty(message = "Email can not be null or empty")
    private String email;

    //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}$", message = "Password must contain minimum 8 characters, 1 upper-case letter, 1 lower-case letter, 1 special-character(@ $ ! % * ? &) and one number")
    @NotEmpty(message = "password can not be null or empty")
    private String password;

    @Size(min = 1, message = "User must be assigned at least 1 role")
    private Set<Integer> roles;

    private boolean isActive;
}
