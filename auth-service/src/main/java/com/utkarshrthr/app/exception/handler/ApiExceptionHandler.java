package com.utkarshrthr.app.exception.handler;

import com.utkarshrthr.app.exception.RoleNotFoundException;
import com.utkarshrthr.app.exception.UserNotFoundException;
import com.utkarshrthr.app.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex){
        return ApiResponse.getError(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Object> handleRoleNotFoundException(RoleNotFoundException ex){
        return ApiResponse.getError(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
