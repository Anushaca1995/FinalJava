package com.nology.finalApi;

public class UserApiNotFoundException extends RuntimeException {
    public UserApiNotFoundException() {
        super("User has not been found");
    }
}