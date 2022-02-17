package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.DemoJpaAdvanceApplication;
import com.example.demo.entity.Course;

@SpringBootTest(classes=DemoJpaAdvanceApplication.class)
class CourseRepositoryTest {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Test
	public void findById_basic() {
		Course course=repository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());
		//logger.info("Testing is running");
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10001L);
		assertNull(repository.findById(10001L));
		//logger.info("Testing is running");
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {
//		 Course course=repository.findById(10001L);
//		 assertEquals("JPA in 50 steps", course.getName());
//		 
//		 //update
//		 course.setName("JPA in 100 steps");
//		 Course course1=repository.findById(10001L);
//		 assertEquals("JPA in 100 steps", course1.getName());
	}
	
	@Test
	@DirtiesContext
	public void PlayWithEntityManger() {
		repository.playWithEntityManager();
	}

}
