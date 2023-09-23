package com.utkarshrthr.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cart {

    private Long id;
    private Long userId;
    private Date date;
}