package com.magenic.ddd.validation.impl.course;

import com.magenic.ddd.domain.course.Course;
import com.magenic.ddd.exception.ValidationFailureException;

public class IsInstructorAvailable extends CourseValidator {
    public IsInstructorAvailable(Course course) {
        super(course);
    }

    @Override
    public void execute() throws ValidationFailureException {

    }
}
