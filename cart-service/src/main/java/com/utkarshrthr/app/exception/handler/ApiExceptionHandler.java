package com.utkarshrthr.app.exception.handler;

import com.utkarshrthr.app.exception.CartNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<String> handleCartNotFoundException(CartNotFoundException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }
}
