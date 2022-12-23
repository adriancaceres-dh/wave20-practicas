package com.bootcamp.Hospital.response;

public class ResponseEntity<T> {

    private String message;

    private boolean error;

    private T body;

    public ResponseEntity(String message, boolean error, T body) {
        this.message = message;
        this.error = error;
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
