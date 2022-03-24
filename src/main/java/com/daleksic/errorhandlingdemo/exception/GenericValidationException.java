package com.daleksic.errorhandlingdemo.exception;

public class GenericValidationException extends RuntimeException{
    public GenericValidationException(String message) {
        super(message);
    }
}
