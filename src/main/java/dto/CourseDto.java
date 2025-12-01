package dto;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CourseType", propOrder = {
        "courseCode",
        "title",
        "ects"
})
public class CourseDto {

    private String courseCode;
    private String title;
    private int ects;

    // Default constructor
    public CourseDto() {
    }

    // All-args constructor
    public CourseDto(String courseCode, String title, int ects) {
        this.courseCode = courseCode;
        this.title = title;
        this.ects = ects;
    }

    // Getters and Setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "courseCode='" + courseCode + '\'' +
                ", title='" + title + '\'' +
                ", ects=" + ects +
                '}';
    }
}

