package com.Springrest.RestApi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springrest.RestApi.dao.CourseDao;
import com.Springrest.RestApi.entities.Course;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
    
//	List<Course> list;
	
	public CourseServiceImpl() 
	{
//		list = new ArrayList<>();
//		list.add(new Course(147, "Java Core", "This book contains java core"));
//		list.add(new Course(4343, "Spring Boot", "contains spring boot tutorial"));
				
	}
	
	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		//return course;
		courseDao.save(course);
		return course;
	}
	
	@Override
	public Course updateCourse(Course course) 
	{
	//	list.forEach(e ->{
	//		if(e.getId() == course.getId()) {
	//			e.setTitle(course.getTitle());
	//			e.setDescription(course.getDescription());
	//		}
	//	});
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
	//	list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Course entity = courseDao.getById(parseLong);
		courseDao.delete(entity);
	}

	
	
	


}
