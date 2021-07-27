package com.magenic.ddd.service;

import com.magenic.ddd.domain.course.registration.CourseRegistration;
import com.magenic.ddd.exception.ValidationFailureException;
import com.magenic.ddd.exception.course.CourseNotFoundException;
import com.magenic.ddd.exception.course.registration.CourseRegistrationNotFoundException;

public interface CourseRegistrationService {
    CourseRegistration registerStudentToCourse(CourseRegistration courseRegistration) throws ValidationFailureException, CourseNotFoundException;
    CourseRegistration getCourseRegistrationById(long courseRegistrationId) throws CourseRegistrationNotFoundException;
}
