package com.magenic.ddd.domain.user;

import com.magenic.ddd.domain.course.CourseCompletion;
import com.magenic.ddd.domain.course.registration.CourseRegistration;
import com.magenic.ddd.domain.shared.constant.ProgramType;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Student extends User {
    @NotNull
    private ProgramType program;

    @OneToMany(mappedBy = "student")
    private List<CourseCompletion> courseCompletions;

    @OneToMany(mappedBy = "student")
    private List<CourseRegistration> courseRegistrations;

    private Date graduationDate;

    @Min(0)
    @Max(4)
    private double gpa;

    public ProgramType getProgram() {
        return program;
    }

    public void setProgram(ProgramType program) {
        this.program = program;
    }

    public List<CourseCompletion> getCourseCompletions() {
        return courseCompletions;
    }

    public void setCourseCompletions(List<CourseCompletion> courseCompletions) {
        this.courseCompletions = courseCompletions;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public List<CourseRegistration> getCourseRegistrations() {
        return courseRegistrations;
    }

    public void setCourseRegistrations(List<CourseRegistration> courseRegistrations) {
        this.courseRegistrations = courseRegistrations;
    }
}
