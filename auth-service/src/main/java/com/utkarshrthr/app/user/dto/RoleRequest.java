package com.utkarshrthr.app.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleRequest {

    @NotEmpty(message = "name can not be null or empty")
    private String name;

    private String description;

    @NotEmpty(message = "type can not be null or empty")
    private String type;

    private boolean isActive = true;
}
