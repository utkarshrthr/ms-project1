package com.utkarshrthr.app.auth.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthResponse {

    private String name;
    private String userId;
    private String email;
    private List<String> roles;
    private String token;
}
