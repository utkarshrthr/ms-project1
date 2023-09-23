package com.utkarshrthr.app.service;

import com.utkarshrthr.app.dto.CartRequest;
import com.utkarshrthr.app.dto.CartResponse;
import com.utkarshrthr.app.dto.ProductResponse;

import java.util.List;

public interface CartService {

    CartResponse getCart(Long cartId);

    List<CartResponse> getAllCarts();

    String addCart(CartRequest cart);

    String updateCart(CartRequest cart);

    void deleteCart(Long cartId);

    //ProductResponse getCartProducts(Long cartId);
}
