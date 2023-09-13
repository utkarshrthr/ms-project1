package com.utkarshrthr.app.exception;

public class UserNotFoundException extends ApiException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
