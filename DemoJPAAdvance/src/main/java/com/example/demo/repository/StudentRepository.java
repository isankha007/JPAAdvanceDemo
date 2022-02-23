package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	 @Autowired
	 EntityManager em;
	 public Student findById(Long id) {
		return em.find(Student.class, id);
		 
	 }
	 
	 public Student save(Student student) {
		 if(student.getId()==null) {
			 em.persist(student);
		 }else {
			 em.merge(student);
		 }
		return student;
		 
	 }
	 
	 public void deleteById(Long id) {
		 Student student=findById(id);
		 em.remove(student);
	 }
	 
	 public void saveStudentWithPassport() {
		 Passport passport=new Passport("z12345");
		 em.persist(passport);
		 Student student = new Student("Mike");
		 student.setPassport(passport);
		// student1.setName("Web service student updated");
		 em.persist(student);
	 }
	 
	 public void operationToUnderStandPersistanceContext() {
			// TODO Auto-generated method stub
			Student student=em.find(Student.class,20001L);
			Passport passport=student.getPassport();
			passport.setNumber("En23331");
			student.setName("Sankhadeep");
		}
	 
	 public void insertHardcodedStudentAndCourse() {
		 Student student = new Student("Jack");
		 Course course = new Course("Microservices in 100 steps");
		 em.persist(student);
		 em.persist(course);
		 
		 student.addCourse(course);
		 course.addStudens(student);
		 
		 em.persist(student);
	 }
	 
	  public void insertStudentAndCourse(Student student,Course course) {
		 em.persist(student);
		 em.persist(course);
		 
		 student.addCourse(course);
		 course.addStudens(student);
		 
		 em.persist(student);
	 }
}
