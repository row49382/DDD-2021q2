package com.magenic.ddd.service;

import com.magenic.ddd.domain.course.Course;
import com.magenic.ddd.exception.ValidationFailureException;
import com.magenic.ddd.exception.course.CourseNotFoundException;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(long id) throws CourseNotFoundException;
    Course createOrUpdateCourse(Course course) throws ValidationFailureException;
    void deleteCourse(long id) throws CourseNotFoundException;
}
