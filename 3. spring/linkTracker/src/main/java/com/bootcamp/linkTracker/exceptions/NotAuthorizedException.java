package com.bootcamp.linkTracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotAuthorizedException extends RuntimeException{

    public NotAuthorizedException (String msg) {
        super(msg);
    }
}
