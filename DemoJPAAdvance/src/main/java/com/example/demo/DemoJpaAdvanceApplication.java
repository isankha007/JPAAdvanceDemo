package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.demo.entity.Course;
import com.example.demo.entity.FullTimeEmployee;
import com.example.demo.entity.ParttimeEmployee;
import com.example.demo.entity.Review;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoJpaAdvanceApplication implements CommandLineRunner{
	
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaAdvanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		//studentRepository.saveStudentWithPassport();
		// TODO Auto-generated method stub
		 //repository.playWithEntityManager();
		//Course course = repository.findById(10001L);//it should not be null in id
//		logger.info("Course 10001->{}",course);
//		repository.save(new Course("microservices"));
		//repository.deleteById(10001L);
		//courseRepository.addHardCodedReviewForCourse();
		
		//List<Review> reviews=new ArrayList<>();
		//reviews.add(new Review("Great hand-on stuff","5"));
		//reviews.add(new Review("Great Awesome","5"));
		//courseRepository.addReviewForCourse(10002L,reviews);
		
		
		//studentRepository.insertStudentAndCourse(new Student("Putin"), new Course("Attack the ukarine"));
		//studentRepository.insertHardcodedStudentAndCourse();
		
		employeeRepository.insert(new FullTimeEmployee("Sankha", new BigDecimal("10000000")));
		employeeRepository.insert(new ParttimeEmployee("Debdoot", new BigDecimal("50")));
		
		//logger.info("all Employees ->{}",employeeRepository.retriveAllTheEmployees());
		logger.info("all fulltime Employees ->{}",employeeRepository.retriveAllFullTimeEmployees());
		logger.info("all parttime Employees ->{}",employeeRepository.retriveAllPartTimeEmployees());
		
	}

}
