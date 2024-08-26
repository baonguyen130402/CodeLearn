package com.env.gs.controller;

import com.env.gs.domain.Course;
import com.env.gs.request.CourseRequest;
import com.env.gs.service.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/course")
@Tag(name = "Course-API")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping()
    public ResponseEntity<?> addNewCourse(@RequestBody CourseRequest request){
        return ResponseEntity.ok(courseService.addCourse(request));
    }
    @GetMapping()
    public ResponseEntity<List<Course>> getAllCourse(){
        List<Course> courseList = courseService.getAll();
        return ResponseEntity.ok(courseList);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Course course = courseService.getById(id);
        return ResponseEntity.ok(course);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateCourse(CourseRequest request , @PathVariable Integer id){
        return ResponseEntity.ok(courseService.update(request,id));
    }
}
