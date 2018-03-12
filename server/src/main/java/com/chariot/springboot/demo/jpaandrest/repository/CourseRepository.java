package com.chariot.springboot.demo.jpaandrest.repository;

import com.chariot.springboot.demo.jpaandrest.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface CourseRepository extends Repository<Course, Long> {
  List<Course> findAll();
}


