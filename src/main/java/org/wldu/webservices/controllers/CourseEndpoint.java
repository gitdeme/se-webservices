package org.wldu.webservices.controllers;

import dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.wldu.webservices.enities.CourseEntity;
import org.wldu.webservices.services.imp.CourseService;
import xsdgenerated.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;

import java.util.List;

@Endpoint
public class CourseEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/course";

    @Autowired
    private CourseService courseService;

    // ================= Create Course =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateCourseRequest")
    @ResponsePayload
    public CreateCourseResponse createCourse(@RequestPayload CreateCourseRequest request) {
        CreateCourseResponse response = new CreateCourseResponse();

        CourseEntity course = new CourseEntity();
        course.setCourseCode(request.getCourse().getCourseCode());
        course.setTitle(request.getCourse().getTitle());
        course.setEcts(request.getCourse().getEcts());

        response.setStatus(courseService.createCourse(course));
        return response;
    }

    // ================= Get Course =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCourseRequest")
    @ResponsePayload
    public GetCourseResponse getCourse(@RequestPayload GetCourseRequest request) {
        GetCourseResponse response = new GetCourseResponse();
        CourseEntity course = courseService.getCourse(request.getCourseCode());
        if (course != null) {
            CourseType dto = new CourseType();
            dto.setCourseCode(course.getCourseCode());
            dto.setTitle(course.getTitle());
            dto.setEcts(course.getEcts());
            response.setCourse(dto);
        }
        return response;
    }

    // ================= Get All Courses =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllCoursesRequest")
    @ResponsePayload
    public GetAllCoursesResponse getAllCourses(@RequestPayload GetAllCoursesRequestType request) {
        GetAllCoursesResponse response = new GetAllCoursesResponse();
        List<CourseEntity> courses = courseService.getAllCourses();
        for (CourseEntity course : courses) {
            CourseType dto = new CourseType();
            dto.setCourseCode(course.getCourseCode());
            dto.setTitle(course.getTitle());
            dto.setEcts(course.getEcts());
            response.getCourse().add(dto);
        }
        return response;
    }

    // ================= Update Course =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateCourseRequest")
    @ResponsePayload
    public UpdateCourseResponse updateCourse(@RequestPayload UpdateCourseRequest request) {
        UpdateCourseResponse response = new UpdateCourseResponse();
        CourseEntity course = new CourseEntity();
        course.setCourseCode(request.getCourse().getCourseCode());
        course.setTitle(request.getCourse().getTitle());
        course.setEcts(request.getCourse().getEcts());

        response.setStatus(courseService.updateCourse(course));
        return response;
    }

    // ================= Delete Course =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteCourseRequest")
    @ResponsePayload
    public DeleteCourseResponse deleteCourse(@RequestPayload DeleteCourseRequest request) {
        DeleteCourseResponse response = new DeleteCourseResponse();
        response.setStatus(courseService.deleteCourse(request.getCourseCode()));
        return response;
    }
}
