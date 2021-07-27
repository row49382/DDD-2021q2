package com.magenic.ddd.service.impl;

import com.magenic.ddd.domain.course.registration.CourseRegistration;
import com.magenic.ddd.exception.ValidationFailureException;
import com.magenic.ddd.exception.course.registration.CourseRegistrationNotFoundException;
import com.magenic.ddd.repository.CourseRegistrationRepository;
import com.magenic.ddd.service.CourseRegistrationService;
import com.magenic.ddd.validation.Validatable;
import com.magenic.ddd.validation.impl.course.registration.factory.CourseRegistrationValidationsFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {

    @Autowired
    private CourseRegistrationValidationsFactory courseRegistrationValidationsFactory;

    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    @Override
    public CourseRegistration registerStudentToCourse(CourseRegistration courseRegistration) throws ValidationFailureException {

        List<Validatable> validations =
                this.courseRegistrationValidationsFactory.generateCourseRegistrationValidations(courseRegistration);

        for (Validatable validation: validations) {
            validation.execute();
        }

        this.courseRegistrationRepository.save(courseRegistration);

        return courseRegistration;
    }

    @Override
    public CourseRegistration getCourseRegistrationById(long courseRegistrationId) throws CourseRegistrationNotFoundException {
        return this.courseRegistrationRepository.findById(courseRegistrationId)
                .orElseThrow(CourseRegistrationNotFoundException::new);
    }
}
