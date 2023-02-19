package com.example.validationexceptionhandling.exception;

public class UserNotFoundException extends Exception{


    public UserNotFoundException(String message) {
        super(message);
    }
}
