package com.kovalenko.backendlab2.exception;

public class CurrencyNotFountException extends EntityNotFoundException {
    public CurrencyNotFountException(String message) {
        super(message);
    }
}
