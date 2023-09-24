package com.utkarshrthr.app.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponse {

    private Integer id;

    private String name;

    private String type;

    private String description;
}
