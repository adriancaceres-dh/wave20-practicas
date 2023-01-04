package com.bootcamp.be_java_hisp_w20_g6.exception;

public class UserReactionExistException extends RuntimeException {
    public UserReactionExistException(String message) {
        super(message);
    }
}
