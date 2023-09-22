package com.utkarshrthr.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.utkarshrthr.app.model.Category;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ProductResponse {

    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
