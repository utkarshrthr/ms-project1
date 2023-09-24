package com.utkarshrthr.app.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse {

    private String username;

    private String firstName;

    private String lastName;

    private String title;

    private String email;

    private boolean isActive;

    private List<String> roles;
}
