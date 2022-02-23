package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.DemoJpaAdvanceApplication;
import com.example.demo.entity.Course;
import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;

@SpringBootTest(classes=DemoJpaAdvanceApplication.class)
class StudentRepositoryTest {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	private void someTest() {
		repository.operationToUnderStandPersistanceContext();

	}

	
	
	@Test
	@Transactional
	public void retriveStudentAndPassportDetail() {
		Student student=em.find(Student.class,20001L);
		//assertEquals("JPA in 50 steps", student.getName());
		logger.info("student->{}",student);
		logger.info("passport->{}",student.getPassport());
	}
	
	@Test
	@Transactional
	public void retrivePassportAndStudentDetail() {
		Passport passport=em.find(Passport.class,40001L);
		//assertEquals("JPA in 50 steps", student.getName());
		logger.info("passport->{}",passport);
		logger.info("Student Detail->{}",passport.getStudent());
	}
	
	

}
