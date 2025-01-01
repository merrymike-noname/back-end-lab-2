package com.kovalenko.backendlab2.exception;

public class InvalidDataException extends IllegalArgumentException {
    public InvalidDataException(String message) {
        super("The input data is invalid: " + message);
    }
}
