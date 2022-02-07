package com.Springrest.RestApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Springrest.RestApi.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
