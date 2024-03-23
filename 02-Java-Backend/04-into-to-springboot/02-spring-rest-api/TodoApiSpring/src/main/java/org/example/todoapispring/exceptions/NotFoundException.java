package org.example.todoapispring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception{
    private String message;
    public NotFoundException(String message) {
        super(message);
    }
}
