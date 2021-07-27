package com.magenic.ddd.service.impl;

import com.magenic.ddd.domain.course.registration.CourseRegistration;
import com.magenic.ddd.domain.shared.constant.CourseRegistrationStatus;
import com.magenic.ddd.exception.ValidationFailureException;
import com.magenic.ddd.exception.course.CourseNotFoundException;
import com.magenic.ddd.exception.course.registration.CourseRegistrationNotFoundException;
import com.magenic.ddd.repository.CourseRegistrationRepository;
import com.magenic.ddd.service.CourseRegistrationService;
import com.magenic.ddd.service.CourseService;
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

    @Autowired
    private CourseService courseService;

    @Override
    public CourseRegistration registerStudentToCourse(CourseRegistration courseRegistration) throws ValidationFailureException, CourseNotFoundException {
        this.courseService.getCourseById(courseRegistration.getCourse().getId());

        List<Validatable> validations =
                this.courseRegistrationValidationsFactory.generateCourseRegistrationValidations(courseRegistration);

        for (Validatable validation: validations) {
            validation.execute();
        }

        courseRegistration.setCourseRegistrationStatus(CourseRegistrationStatus.Approved);
        this.courseRegistrationRepository.save(courseRegistration);

        return courseRegistration;
    }

    @Override
    public CourseRegistration getCourseRegistrationById(long courseRegistrationId) throws CourseRegistrationNotFoundException {
        return this.courseRegistrationRepository.findById(courseRegistrationId)
                .orElseThrow(CourseRegistrationNotFoundException::new);
    }
}
