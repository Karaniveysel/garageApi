package com.example.services.exception;

import org.springframework.http.HttpStatus;

public class ResourceException  extends RuntimeException {

    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    private String message;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ResourceException(HttpStatus httpStatus, Throwable ex) {
        super(ex.getLocalizedMessage());
        this.message=ex.getLocalizedMessage();
        this.httpStatus = httpStatus;
    }

    public ResourceException(HttpStatus httpStatus, Throwable ex,String message) {
        super(message);
        this.message=message;
        this.httpStatus = httpStatus;
    }



    @Override
    public String toString() {
        return "{" + " messages=" + message + ", error=" + httpStatus.value() + '}';
    }
}