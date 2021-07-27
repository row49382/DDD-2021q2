package com.magenic.ddd.service.impl;

import com.magenic.ddd.domain.course.Course;
import com.magenic.ddd.exception.ValidationFailureException;
import com.magenic.ddd.exception.course.CourseNotFoundException;
import com.magenic.ddd.repository.CourseRepository;
import com.magenic.ddd.service.CourseService;
import com.magenic.ddd.validation.Validatable;
import com.magenic.ddd.validation.impl.course.factory.CourseValidationsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseValidationsFactory courseValidationsFactory;

    @Override
    public List<Course> getAllCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course getCourseById(long id) throws CourseNotFoundException {
        return this.courseRepository.findById(id)
                .orElseThrow(CourseNotFoundException::new);
    }

    @Override
    public Course createOrUpdateCourse(Course course) throws ValidationFailureException {
        Course createdOrUpdatedCourse = course;

        List<Validatable> validations = this.courseValidationsFactory.generateCourseValidations(course);

        for (Validatable validation: validations) {
            validation.execute();
        }

        if (!this.courseRepository.findById(course.getId()).isPresent()) {
            createdOrUpdatedCourse = Course.from(course);
        }

        this.courseRepository.save(createdOrUpdatedCourse);

        return course;
    }

    @Override
    public void deleteCourse(long id) throws CourseNotFoundException {
        Course course = this.getCourseById(id);
        this.courseRepository.delete(course);
    }
}
