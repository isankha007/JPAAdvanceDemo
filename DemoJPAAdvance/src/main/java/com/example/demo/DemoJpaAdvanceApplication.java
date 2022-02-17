package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoJpaAdvanceApplication implements CommandLineRunner{
	
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaAdvanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepository.saveStudentWithPassport();
		// TODO Auto-generated method stub
		 //repository.playWithEntityManager();
		//Course course = repository.findById(10001L);//it should not be null in id
//		logger.info("Course 10001->{}",course);
//		repository.save(new Course("microservices"));
		//repository.deleteById(10001L);
		
	}

}
