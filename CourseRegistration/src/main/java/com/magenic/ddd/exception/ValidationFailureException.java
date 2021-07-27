package com.magenic.ddd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidationFailureException extends Exception {

    public ValidationFailureException(String msg) {
        super(msg);
    }

    public ValidationFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
