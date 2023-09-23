package com.utkarshrthr.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class CartResponse {

    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
