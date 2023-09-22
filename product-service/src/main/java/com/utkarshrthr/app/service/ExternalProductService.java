package com.utkarshrthr.app.service;

import com.utkarshrthr.app.adapter.ExternalProductServiceAdapter;
import com.utkarshrthr.app.dto.ProductRequest;
import com.utkarshrthr.app.dto.ProductResponse;
import com.utkarshrthr.app.exception.ProductNotFoundException;
import com.utkarshrthr.app.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ExternalProductService implements ProductService {

    private final ExternalProductServiceAdapter serviceAdapter;

    public ExternalProductService(ExternalProductServiceAdapter serviceAdapter) {
        this.serviceAdapter = serviceAdapter;
    }

    @Override
    public ProductResponse getProduct(Long productId) {
        Product product = serviceAdapter.getProduct(productId);

        if(product == null)
            throw new ProductNotFoundException("No product exists for id: "+ productId);

        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return null;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = serviceAdapter.getAllProducts();

        if(CollectionUtils.isEmpty(products))
            return Collections.emptyList();

        List<ProductResponse> responses = new ArrayList<>();

        products.forEach(product -> {
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(product, productResponse);
            responses.add(productResponse);
        });

        return responses;
    }

    @Override
    public String addProduct(ProductRequest product) {
        return null;
    }

    @Override
    public String updateProduct(ProductRequest product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
