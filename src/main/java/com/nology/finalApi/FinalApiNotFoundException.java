package com.nology.finalApi;

public class FinalApiNotFoundException extends RuntimeException {
    public FinalApiNotFoundException() {
        super("User has not been found");
    }
}