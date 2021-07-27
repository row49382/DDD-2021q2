package com.magenic.ddd.validation.impl.course.registration;

import com.magenic.ddd.domain.course.registration.CourseRegistration;
import com.magenic.ddd.exception.ValidationFailureException;

public class IsCourseAtCapacity extends CourseRegistrationValidator {
    public IsCourseAtCapacity(CourseRegistration courseRegistration) {
        super(courseRegistration);
    }

    @Override
    public void execute() throws ValidationFailureException {

    }
}
