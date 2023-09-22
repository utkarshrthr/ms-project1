package com.utkarshrthr.app.exception.handler;

import com.utkarshrthr.app.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }
}
