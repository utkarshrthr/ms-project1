package com.utkarshrthr.app.exception;

import com.utkarshrthr.app.util.ApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleValidationExceptions(ConstraintViolationException ex) {

        Map<String, String> collect = ex.getConstraintViolations()
                .stream()
                .collect(Collectors.toMap(x -> x.getPropertyPath().toString(), ConstraintViolation::getMessage));
        return ApiResponse.getError(HttpStatus.BAD_REQUEST, collect);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> collect = ex.getBindingResult().getAllErrors()
                .stream().
                collect(Collectors.toMap(error -> ((FieldError) error).getField(), DefaultMessageSourceResolvable::getDefaultMessage));
        return ApiResponse.getError(HttpStatus.BAD_REQUEST, collect);
    }
}
