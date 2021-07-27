package com.magenic.ddd.domain.user;

import com.magenic.ddd.domain.course.Course;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;
import java.math.BigDecimal;

@Entity
public class Faculty extends Employee {
    private boolean isTenured;

    @ManyToMany(mappedBy = "instructors")
    private List<Course> courses;

    public boolean isTenured() {
        return isTenured;
    }

    public void setTenured(boolean tenured) {
        isTenured = tenured;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public BigDecimal calculatePay() {
        return null;
    }
}
