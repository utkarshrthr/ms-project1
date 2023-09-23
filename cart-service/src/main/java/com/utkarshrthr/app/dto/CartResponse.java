package com.utkarshrthr.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class CartResponse {

    private Long id;
    private Long userId;
    private Date date;
    List<ProductResponse> products;
}
