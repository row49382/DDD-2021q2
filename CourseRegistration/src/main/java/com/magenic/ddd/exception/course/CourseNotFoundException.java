package com.magenic.ddd.exception.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends Exception {
    public CourseNotFoundException() {
        super("Course was not found");
    }

    public CourseNotFoundException(String msg) {
        super(msg);
    }

    public CourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
