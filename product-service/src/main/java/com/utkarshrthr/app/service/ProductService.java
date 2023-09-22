package com.utkarshrthr.app.service;

import com.utkarshrthr.app.dto.ProductRequest;
import com.utkarshrthr.app.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse getProduct(Long productId);

    List<ProductResponse> getAllProducts();

    String addProduct(ProductRequest product);

    String updateProduct(ProductRequest product);

    void deleteProduct(Long productId);
}
