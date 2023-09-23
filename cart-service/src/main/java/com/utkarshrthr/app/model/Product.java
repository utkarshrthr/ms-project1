package com.utkarshrthr.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cart {

    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}