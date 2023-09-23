package com.utkarshrthr.app.adapter;

import com.utkarshrthr.app.model.Cart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ExternalCartServiceAdapter implements CartServiceAdapter {

    private final RestTemplate restTemplate;

    public ExternalCartServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${app.external.cart-endpoint}")
    private String cartApiURL;

    @Override
    public Cart getCart(Long cartId) {
        return restTemplate.getForObject(cartApiURL+"/"+cartId, Cart.class);
    }

    @Override
    public List<Cart> getAllCarts() {
        Cart[] carts = restTemplate.getForObject(cartApiURL, Cart[].class);
        return Arrays.asList(carts);
    }

    @Override
    public String addCart(Cart cart) {
        return null;
    }

    @Override
    public String updateCart(Cart cart) {
        return null;
    }

    @Override
    public void deleteCart(Long cartId) {

    }
}
