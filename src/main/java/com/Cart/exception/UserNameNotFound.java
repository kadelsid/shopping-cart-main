package com.Cart.exception;

public class UserNameNotFound extends RuntimeException{

    private final String message;

    public UserNameNotFound(String message) {
        super(message);
        this.message = message;
    }

}
