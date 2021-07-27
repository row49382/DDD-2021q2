package com.magenic.ddd.domain.course;

import com.magenic.ddd.domain.shared.AuditingBaseEntity;
import com.magenic.ddd.domain.user.Student;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class CourseCompletion extends AuditingBaseEntity {
    @Min(1)
    private int credits;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    @NotNull
    @ManyToOne(targetEntity = Course.class, cascade = CascadeType.ALL)
    private Course course;

    @Min(0)
    @Max(100)
    private double gradePercentage;

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

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

    public double getGradePercentage() {
        return gradePercentage;
    }

    public void setGradePercentage(double gradePercentage) {
        this.gradePercentage = gradePercentage;
    }

    /**
     * Checks if a student passes based on if the grade percentage is greater than 60% (D-)
     * @return If the student passed the course
     */
    public boolean didStudentPassCourse() {
        return gradePercentage > 60.0;
    }
}
