package com.utkarshrthr.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartRequest {

    private String userId;
    private List<ProductResponse> products;
}
