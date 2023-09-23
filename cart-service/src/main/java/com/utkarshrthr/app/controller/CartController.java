package com.utkarshrthr.app.controller;

import com.utkarshrthr.app.dto.CartResponse;
import com.utkarshrthr.app.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/carts")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CartResponse>> getAllCarts(){
        List<CartResponse> carts = service.getAllCarts();
        return CollectionUtils.isEmpty(carts) ? ResponseEntity.noContent().build() : ResponseEntity.ok(carts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CartResponse> getCart(@PathVariable Long id){
        CartResponse cart = service.getCart(id);
        return ResponseEntity.ok(cart);
    }
}
