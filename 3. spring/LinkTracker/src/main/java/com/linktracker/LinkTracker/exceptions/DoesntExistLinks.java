package com.linktracker.LinkTracker.exceptions;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DoesntExistLinks extends RuntimeException {
    public DoesntExistLinks(String message){
        super(message);
    }

}
