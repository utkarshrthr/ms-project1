package com.utkarshrthr.app.service;

import com.utkarshrthr.app.adapter.ExternalCartServiceAdapter;
import com.utkarshrthr.app.dto.CartRequest;
import com.utkarshrthr.app.dto.CartResponse;
import com.utkarshrthr.app.exception.CartNotFoundException;
import com.utkarshrthr.app.model.Cart;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ExternalCartService implements CartService {

    private final ExternalCartServiceAdapter serviceAdapter;

    public ExternalCartService(ExternalCartServiceAdapter serviceAdapter) {
        this.serviceAdapter = serviceAdapter;
    }

    @Override
    public CartResponse getCart(Long cartId) {
        Cart cart = serviceAdapter.getCart(cartId);

        if(cart == null)
            throw new CartNotFoundException("No cart exists for id: "+ cartId);

        CartResponse cartResponse = new CartResponse();
        BeanUtils.copyProperties(cart, cartResponse);
        return null;
    }

    @Override
    public List<CartResponse> getAllCarts() {
        List<Cart> carts = serviceAdapter.getAllCarts();

        if(CollectionUtils.isEmpty(carts))
            return Collections.emptyList();

        List<CartResponse> responses = new ArrayList<>();

        carts.forEach(cart -> {
            CartResponse cartResponse = new CartResponse();
            BeanUtils.copyProperties(cart, cartResponse);
            responses.add(cartResponse);
        });

        return responses;
    }

    @Override
    public String addCart(CartRequest cart) {
        return null;
    }

    @Override
    public String updateCart(CartRequest cart) {
        return null;
    }

    @Override
    public void deleteCart(Long cartId) {

    }
}
