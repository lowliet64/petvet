package com.example.petvet.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InstanceNotFoundException extends RuntimeException {

    public static final long serialVersionUID=1L;

    public InstanceNotFoundException(String message) {
        super(message);
    }
}
