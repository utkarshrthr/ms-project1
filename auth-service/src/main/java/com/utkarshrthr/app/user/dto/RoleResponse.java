package com.utkarshrthr.app.user.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class RoleResponse extends RepresentationModel<RoleResponse> {

    private Integer id;

    private String name;

    private String type;

    private String description;
}
