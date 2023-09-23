package com.utkarshrthr.app.controller;

import com.utkarshrthr.app.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url = "${app.external.product-endpoint}")
public interface ProductController {

    @GetMapping
    List<ProductResponse> getProducts();

    @GetMapping("/{productId}")
    ProductResponse getProduct(@PathVariable Long productId);
}
