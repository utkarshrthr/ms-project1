package com.utkarshrthr.app.service;

import com.utkarshrthr.app.dto.CartRequest;
import com.utkarshrthr.app.dto.CartResponse;

import java.util.List;

public interface CartService {

    CartResponse getCart(Long cartId);

    List<CartResponse> getAllCarts();

    String addCart(CartRequest cart);

    String updateCart(CartRequest cart);

    void deleteCart(Long cartId);
}
