package com.eduhub.instructorservice.exception;

public class ReferenceNotFoundException extends  RuntimeException{

    private static final long serialVersionUID = -6638849627494498004L;

    public ReferenceNotFoundException(String message) {
        super(message);
    }
}
