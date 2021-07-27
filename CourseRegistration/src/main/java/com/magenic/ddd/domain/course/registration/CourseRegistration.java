package com.magenic.ddd.domain.course.registration;

import com.magenic.ddd.domain.course.Course;
import com.magenic.ddd.domain.shared.AuditingBaseEntity;
import com.magenic.ddd.domain.shared.constant.CourseRegistrationStatus;
import com.magenic.ddd.domain.user.Student;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CourseRegistration extends AuditingBaseEntity {
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    @NotNull
    @ManyToOne(targetEntity = Course.class, cascade = CascadeType.ALL)
    private Course course;

    private CourseRegistrationStatus courseRegistrationStatus;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public CourseRegistrationStatus getCourseRegistrationStatus() {
        return courseRegistrationStatus;
    }

    public void setCourseRegistrationStatus(CourseRegistrationStatus courseRegistrationStatus) {
        this.courseRegistrationStatus = courseRegistrationStatus;
    }
}
