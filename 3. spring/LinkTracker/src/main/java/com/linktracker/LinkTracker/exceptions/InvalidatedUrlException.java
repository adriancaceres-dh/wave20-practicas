package com.linktracker.LinkTracker.exceptions;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidatedUrlException extends RuntimeException{

    public InvalidatedUrlException(String message){
        super(message);
    }
}
