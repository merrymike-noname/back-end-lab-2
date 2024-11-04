package com.kovalenko.backendlab2.exception;

public class RecordNotFoundException extends EntityNotFoundException{
    public RecordNotFoundException(String message) {
        super(message);
    }
}
