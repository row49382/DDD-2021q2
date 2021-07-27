package com.magenic.ddd.domain.course;

import com.magenic.ddd.domain.course.registration.CourseRegistration;
import com.magenic.ddd.domain.shared.constant.DepartmentType;
import com.magenic.ddd.domain.shared.AuditingBaseEntity;
import com.magenic.ddd.domain.shared.constant.ProgramType;
import com.magenic.ddd.domain.user.Faculty;

import java.util.Date;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Course extends AuditingBaseEntity {
    @NotEmpty
    private String title;

    @NotNull
    private DepartmentType department;

    @NotEmpty
    @ManyToMany
    private List<Faculty> instructors;

    @OneToOne(targetEntity = BookOptions.class)
    private BookOptions bookOptions;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @Min(0)
    @Max(30)
    private int capacity;

    @NotNull
    private ProgramType program;

    @ElementCollection(targetClass = Course.class)
    private List<Course> prerequisiteCourses;

    @Min(1)
    private int credits;

    @OneToMany(mappedBy = "course")
    private List<CourseRegistration> courseRegistrations;

    /**
     * static factory for creating new courses from an existing course.
     * @param course The course that will have its properties used for generation
     * @return The course with the properties of the course provided and a new unique id
     */
    public static Course from(Course course) {
        Course newCourse = new Course();
        newCourse.setTitle(course.getTitle());
        newCourse.setDepartment(course.getDepartment());
        newCourse.setInstructors(course.getInstructors());
        newCourse.setBookOptions(course.getBookOptions());
        newCourse.setStartDate(course.getStartDate());
        newCourse.setEndDate(course.getEndDate());
        newCourse.setCapacity(course.getCapacity());
        newCourse.setProgram(course.getProgram());
        newCourse.setPrerequisiteCourses(course.getPrerequisiteCourses());
        newCourse.setCredits(course.getCredits());
        newCourse.setCourseRegistrations(course.getCourseRegistrations());

        return newCourse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DepartmentType getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentType department) {
        this.department = department;
    }

    public List<Faculty> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Faculty> instructors) {
        this.instructors = instructors;
    }

    public BookOptions getBookOptions() {
        return bookOptions;
    }

    public void setBookOptions(BookOptions bookOptions) {
        this.bookOptions = bookOptions;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ProgramType getProgram() {
        return program;
    }

    public void setProgram(ProgramType program) {
        this.program = program;
    }

    public List<Course> getPrerequisiteCourses() {
        return prerequisiteCourses;
    }

    public void setPrerequisiteCourses(List<Course> prerequisiteCourses) {
        this.prerequisiteCourses = prerequisiteCourses;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<CourseRegistration> getCourseRegistrations() {
        return courseRegistrations;
    }

    public void setCourseRegistrations(List<CourseRegistration> courseRegistrations) {
        this.courseRegistrations = courseRegistrations;
    }
}
