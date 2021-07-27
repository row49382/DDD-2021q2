package com.magenic.ddd.exception.course.registration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CourseRegistrationNotFoundException extends Exception {
    public CourseRegistrationNotFoundException() {
        super("Course Registration was not found");
    }

    public CourseRegistrationNotFoundException(String msg) {
        super(msg);
    }

    public CourseRegistrationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
