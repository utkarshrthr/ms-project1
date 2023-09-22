package com.utkarshrthr.app.controller;

import com.utkarshrthr.app.dto.ProductResponse;
import com.utkarshrthr.app.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> products = service.getAllProducts();
        return CollectionUtils.isEmpty(products) ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id){
        ProductResponse product = service.getProduct(id);
        return ResponseEntity.ok(product);
    }
}
