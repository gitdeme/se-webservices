package org.wldu.webservices.enities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "courses")
public class CourseEntity {

    @Id
    @Column(name = "course_code", length = 10)
    @NotBlank(message = "Course code is required")
    private String courseCode;

    @NotBlank(message = "Title is required")
    @Column(nullable = false)
    private String title;

    @Min(value = 1, message = "ECTS must be >= 1")
    @Column(nullable = false)
    private int ects;

    public CourseEntity() {}

    public CourseEntity(String courseCode, String title, int ects) {
        this.courseCode = courseCode;
        this.title = title;
        this.ects = ects;
    }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getEcts() { return ects; }
    public void setEcts(int ects) { this.ects = ects; }
}
