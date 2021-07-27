package com.magenic.ddd.controller;

import com.magenic.ddd.domain.course.Course;

import java.util.List;
import java.util.Optional;

import com.magenic.ddd.exception.ValidationFailureException;
import com.magenic.ddd.exception.course.CourseNotFoundException;
import com.magenic.ddd.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = this.courseService.getAllCourses();
        return ResponseEntity.of(Optional.of(courses));
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable long courseId) throws CourseNotFoundException {
        Course course = this.courseService.getCourseById(courseId);
        return ResponseEntity.of(Optional.of(course));
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@Valid @RequestParam Course course) throws ValidationFailureException {
        Course newOrUpdatedCourse = this.courseService.createOrUpdateCourse(course);
        return ResponseEntity.of(Optional.of(newOrUpdatedCourse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable long id) throws CourseNotFoundException {
        this.courseService.deleteCourse(id);
        return ResponseEntity.of(Optional.of(Boolean.valueOf("true")));
    }
}
