package com.utkarshrthr.app.adapter;

import com.utkarshrthr.app.model.Product;

import java.util.List;

public interface ProductServiceAdapter {

    Product getProduct(Long productId);

    List<Product> getAllProducts();

    String addProduct(Product product);

    String updateProduct(Product product);

    void deleteProduct(Long productId);
}
