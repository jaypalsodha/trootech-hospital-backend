package com.trootech.Hospitalappbackend.exception;

public class DoctorAlreadyExistException extends RuntimeException {
    public DoctorAlreadyExistException(String message) {
        super(message);
    }
}
