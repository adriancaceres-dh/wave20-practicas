package com.linktracker.LinkTracker.exceptions;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DoesntExistLinksException extends RuntimeException {
    public DoesntExistLinksException(String message){
        super(message);
    }

}
