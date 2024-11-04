package com.kovalenko.backendlab2.exception;

public class EmptyParametersException extends RuntimeException {
    public EmptyParametersException(String message) {
        super(message);
    }
}
