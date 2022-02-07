package com.Springrest.RestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Springrest.RestApi.entities.Course;
import com.Springrest.RestApi.services.CourseService;

@RestController
@CrossOrigin
public class MyContoller {
   @Autowired
   private CourseService courseservice;
   
   @GetMapping("/home")
   public String home() {
	  return "this is my spring boot app";  
   }
	
   @GetMapping("/course")	
   public List<Course> getCourses()
    {
	return this.courseservice.getCourses();
	
    }
   @PostMapping("/course")
   public Course addCourse(@RequestBody Course course) 
   {
	   return this.courseservice.addCourse(course);   
	   
   }
   @PutMapping("/course")
   public Course updateCourse(@RequestBody Course course) 
   {
	   return this.courseservice.updateCourse(course);
   }
   
   @DeleteMapping("/course/{courseId}")
   public void deleteCourse(@PathVariable String courseId)
   {
	  
	   this.courseservice.deleteCourse(Long.parseLong(courseId));
   }
   
}
