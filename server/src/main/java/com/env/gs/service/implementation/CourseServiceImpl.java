package com.env.gs.service.implementation;

import com.env.gs.domain.Course;
import com.env.gs.repository.CourseRepository;
import com.env.gs.request.CourseRequest;
import com.env.gs.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course addCourse(CourseRequest request) {
        Course course = new Course();
        Random random = new Random();
        int id = random.nextInt();

        course.setCourseId(id);
        course.setDescription(request.getDescription());
        course.setCourseName(request.getCourseName());
        course.setStatus(request.getStatus());
        course.setLevel(request.getLevel());
        course.setUpdateDate(request.getUpdateDate());
        course.setStudyHours(request.getStudyHours());

        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAll() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    @Override
    public Course getById(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow();
        return course;
    }

    @Override
    public Course update(CourseRequest request, Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow();
        course.setStudyHours(request.getStudyHours());
        course.setDescription(request.getDescription());
        course.setStatus(request.getStatus());
        course.setCourseName(request.getCourseName());
        course.setLevel(request.getLevel());
        course.setUpdateDate(request.getUpdateDate());

        return courseRepository.save(course);
    }
}
