package com.magenic.ddd.validation;

import com.magenic.ddd.exception.ValidationFailureException;

public interface Validatable {
    void execute() throws ValidationFailureException;
}
