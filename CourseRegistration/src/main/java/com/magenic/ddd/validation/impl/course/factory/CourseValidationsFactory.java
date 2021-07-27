package com.magenic.ddd.validation.impl.course.factory;

import com.magenic.ddd.domain.course.Course;
import com.magenic.ddd.validation.Validatable;
import java.util.List;

import com.magenic.ddd.validation.impl.course.IsInstructorAvailable;
import com.magenic.ddd.validation.impl.course.IsRoomAvailable;
import org.springframework.stereotype.Component;

@Component
public class CourseValidationsFactory {
    public List<Validatable> generateCourseValidations(Course course) {
        return List.of(
            new IsInstructorAvailable(course),
            new IsRoomAvailable(course)
        );
    }
}
