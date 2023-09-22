package com.utkarshrthr.app.dto;

import com.utkarshrthr.app.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
