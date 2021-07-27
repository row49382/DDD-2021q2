package com.magenic.ddd.controller;

import com.magenic.ddd.domain.course.registration.CourseRegistration;
import com.magenic.ddd.exception.ValidationFailureException;
import com.magenic.ddd.exception.course.registration.CourseRegistrationNotFoundException;
import com.magenic.ddd.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/course/register")
public class CourseRegistrationController {

    @Autowired
    private CourseRegistrationService courseRegistrationService;

    @PostMapping
    public ResponseEntity<CourseRegistration> registerCourse(@Valid @RequestParam CourseRegistration courseRegistration) throws ValidationFailureException {
        CourseRegistration createdCourseRegistration = this.courseRegistrationService.registerStudentToCourse(courseRegistration);
        return ResponseEntity.of(Optional.of(createdCourseRegistration));
    }

    @GetMapping("/{courseRegistrationId}")
    public ResponseEntity<CourseRegistration> getCourseRegistration(@PathVariable long courseRegistrationId) throws CourseRegistrationNotFoundException {
        CourseRegistration courseRegistration = this.courseRegistrationService.getCourseRegistrationById(courseRegistrationId);
        return ResponseEntity.of(Optional.of(courseRegistration));
    }
}
