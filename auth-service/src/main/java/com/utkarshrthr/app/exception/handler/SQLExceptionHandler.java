package com.utkarshrthr.app.exception.handler;

import com.utkarshrthr.app.util.ApiResponse;
import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SQLExceptionHandler {

    /*@ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex){
        return ApiResponse.getError(HttpStatus.BAD_REQUEST, ex.getMessage());
    }*/

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex){
        return ApiResponse.getError(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<Object> handlePropertyValueException(PropertyValueException ex){
        return ApiResponse.getError(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(DataException.class)
    public ResponseEntity<Object> handleDataException(DataException ex){
        return ApiResponse.getError(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
