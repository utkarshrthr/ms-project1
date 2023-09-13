package com.utkarshrthr.app.exception;

public class ApiException extends RuntimeException {

    public ApiException(String message){
        super(message);
    }
}
