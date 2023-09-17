package com.utkarshrthr.app.user.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class UserRequest {

    @NotEmpty(message = "username can not be null or empty")
    private String username;

    @NotEmpty(message = "First name can not be null or empty")
    private String firstName;

    @NotEmpty(message = "last name can not be null or empty")
    private String lastName;

    @NotEmpty(message = "username can not be null or empty")
    private String title; // TODO -> title need to be validated against a set of values

    @Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Invalid email format.")
//    @NotEmpty(message = "Email can not be null or empty")
    private String email;

    //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}$", message = "Password must contain minimum 8 characters, 1 upper-case letter, 1 lower-case letter, 1 special-character(@ $ ! % * ? &) and one number")
    // @NotEmpty(message = "password can not be null or empty")
    private String password;

    @Size(min = 1, message = "User must be assigned at least 1 role")
    private Set<String> roles;

    private boolean isActive;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
