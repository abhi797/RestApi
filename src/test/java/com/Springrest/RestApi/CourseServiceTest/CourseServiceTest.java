package com.Springrest.RestApi.CourseServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.Springrest.RestApi.dao.CourseDao;
import com.Springrest.RestApi.entities.Course;
import com.Springrest.RestApi.services.CourseServiceImpl;

import java.util.Collections;
import java.util.List;
@ExtendWith(MockitoExtension.class)

public class CourseServiceTest {
	
    @Mock
	private CourseDao dao;
	
	private CourseServiceImpl courseService;
	@BeforeEach
	void setUp() {
		this.courseService = new CourseServiceImpl(dao);
	}
	
	@Test
	void getCourses() {
		//courseService.getCourses();
		//verify(dao).findAll();
		List<Course> list = dao.findAll();
		//List<Course> list1 = cou
		assertThat(list).isEqualTo(courseService.getCourses());
		
	}
	@Test
	void addCourse() {
		Course c = new Course();
		c.setId(123);
		c.setTitle("SST");
		c.setDescription("This is desc");
		dao.save(c);
		assertThat(c).isEqualTo(courseService.addCourse(c));
	}
	@Test
	void deleteCourse() {
		dao.deleteById(0L);
		//assertThat(dao.existsById(1L)).isFalse();
		assertThat(dao.count()).isEqualTo(1);
	}
	
	@Test
     void deleteAll() {
	 dao.deleteById(0L);
	 assertThat(dao.count()).isEqualTo(0);
	}
	
	//public void TestmethodPM() {
		//String call = "Using power mockito method";
		//String callExpectation  = "Calling expection of method";
		
	    //PowerMockito.mockStatic(CourseServiceImpl.class);  
	    //PowerMockito.when(CourseServiceImpl.staticMethod(call)).thenReturn(callExpectation); 
	    
	   // String actualcall = CourseServiceImpl.staticMethod(call);  
	    //assertEquals(callExpectation, actualcall);  

	//}
	
	

}
