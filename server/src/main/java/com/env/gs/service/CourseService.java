package com.env.gs.service;

import com.env.gs.domain.Course;
import com.env.gs.request.CourseRequest;

import java.util.List;

public interface CourseService {

    Course addCourse(CourseRequest request);
    List<Course> getAll();
    Course getById(Integer id);
    Course update(CourseRequest request, Integer id);
}
