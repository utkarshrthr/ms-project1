package com.utkarshrthr.app.adapter;

import com.utkarshrthr.app.model.Cart;

import java.util.List;

public interface CartServiceAdapter {

    Cart getCart(Long cartId);

    List<Cart> getAllCarts();

    String addCart(Cart cart);

    String updateCart(Cart cart);

    void deleteCart(Long cartId);
}
