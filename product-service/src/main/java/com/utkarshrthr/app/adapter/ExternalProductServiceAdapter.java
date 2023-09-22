package com.utkarshrthr.app.adapter;

import com.utkarshrthr.app.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ExternalProductServiceAdapter implements ProductServiceAdapter {

    private final RestTemplate restTemplate;

    public ExternalProductServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${app.external.product-endpoint}")
    private String productApiURL;

    @Override
    public Product getProduct(Long productId) {
        return restTemplate.getForObject(productApiURL+"/"+productId, Product.class);
    }

    @Override
    public List<Product> getAllProducts() {
        Product[] products = restTemplate.getForObject(productApiURL, Product[].class);
        return Arrays.asList(products);
    }

    @Override
    public String addProduct(Product product) {
        return null;
    }

    @Override
    public String updateProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
