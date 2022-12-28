package com.bootcamp.link_tracker.exception;

public class LinkNotFoundException extends RuntimeException {
    private static final String message = "Link not found";

    public LinkNotFoundException() {
        super(message);
    }
}
