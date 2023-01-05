package com.socialmeli.be_java_hisp_w20_g8.exceptions;

public class DoesntExistSellerException extends RuntimeException {

    public DoesntExistSellerException(String message) {
        super(message);
    }
}
