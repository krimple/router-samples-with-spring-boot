package com.chariot.springboot.demo.jpaandrest.rest;
import java.util.List;
import com.chariot.springboot.demo.jpaandrest.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import com.chariot.springboot.demo.jpaandrest.repository.*;
import com.chariot.springboot.demo.jpaandrest.domain.*;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:4200",
             allowCredentials = "true",
             allowedHeaders = "*")
public class CourseController {

    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/course")
    List<Course> getAllCourses() {
        return this.courseRepository.findAll();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CourseController.class, args);
    }
}

