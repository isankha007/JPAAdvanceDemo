package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Employee;
import com.example.demo.entity.FullTimeEmployee;
import com.example.demo.entity.ParttimeEmployee;
import com.example.demo.entity.Review;

@Repository
@Transactional
public class EmployeeRepository {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	 @Autowired
	 EntityManager em;
	 
	 public void insert(Employee employee) {
		 em.persist(employee);
	 }
	
	 //
//	 public List<Employee> retriveAllTheEmployees() {
//		return em.createQuery("select e from Employee e",Employee.class).getResultList();
//		 
//	 }
	 
	 //for mapped super class
	 public List<ParttimeEmployee> retriveAllPartTimeEmployees() {
			return em.createQuery("select e from ParttimeEmployee e",ParttimeEmployee.class).getResultList();
			 
		 }
	 
	 public List<FullTimeEmployee> retriveAllFullTimeEmployees() {
			return em.createQuery("select e from FullTimeEmployee e",FullTimeEmployee.class).getResultList();
			 
		 }
	 
}
