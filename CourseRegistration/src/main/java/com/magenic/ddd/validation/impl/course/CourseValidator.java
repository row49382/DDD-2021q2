package com.magenic.ddd.validation.impl.course;

import com.magenic.ddd.domain.course.Course;
import com.magenic.ddd.validation.Validatable;

public abstract class CourseValidator implements Validatable {
    private Course course;

    protected CourseValidator(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }
}
