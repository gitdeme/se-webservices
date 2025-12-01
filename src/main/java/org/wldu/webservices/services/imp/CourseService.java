package org.wldu.webservices.services.imp;

import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wldu.webservices.enities.CourseEntity;
import org.wldu.webservices.repositories.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public String createCourse(CourseEntity course) {
        courseRepository.save(course);
        return "Course Created Successfully";
    }

    public CourseEntity getCourse(String courseCode) {
        Optional<CourseEntity> course = courseRepository.findById(courseCode);
        return course.orElse(null);
    }

    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    public String updateCourse(CourseEntity course) {
        if(courseRepository.existsById(course.getCourseCode())) {
            courseRepository.save(course);
            return "Course Updated Successfully";
        }
        return "Course Not Found";
    }

    public String deleteCourse(String courseCode) {
        if(courseRepository.existsById(courseCode)) {
            courseRepository.deleteById(courseCode);
            return "Course Deleted Successfully";
        }
        return "Course Not Found";
    }
}
