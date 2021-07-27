package com.magenic.ddd.validation.impl.course.registration;

import com.magenic.ddd.domain.course.registration.CourseRegistration;
import com.magenic.ddd.validation.Validatable;

public abstract class CourseRegistrationValidator implements Validatable {
    private CourseRegistration courseRegistration;

    protected CourseRegistrationValidator(CourseRegistration courseRegistration) {
        this.courseRegistration = courseRegistration;
    }

    protected CourseRegistration getCourseRegistration() {
        return courseRegistration;
    }
}
