package com.magenic.ddd.validation.impl.course.registration.factory;

import com.magenic.ddd.domain.course.registration.CourseRegistration;
import com.magenic.ddd.validation.Validatable;
import java.util.List;

import com.magenic.ddd.validation.impl.course.registration.ArePrerequisitesMet;
import com.magenic.ddd.validation.impl.course.registration.IsCourseAtCapacity;
import com.magenic.ddd.validation.impl.course.registration.IsStudentAllowedToRegister;
import com.magenic.ddd.validation.impl.course.registration.IsStudentInCorrectProgramForCourse;
import org.springframework.stereotype.Component;

@Component
public class CourseRegistrationValidationsFactory {
    public List<Validatable> generateCourseRegistrationValidations(CourseRegistration courseRegistration) {
        return List.of(
                new ArePrerequisitesMet(courseRegistration),
                new IsCourseAtCapacity(courseRegistration),
                new IsStudentAllowedToRegister(courseRegistration),
                new IsStudentInCorrectProgramForCourse(courseRegistration)
        );
    }
}
