package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.DemoJpaAdvanceApplication;
import com.example.demo.entity.Course;

@SpringBootTest(classes=DemoJpaAdvanceApplication.class)
class JpqlTest {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test
	public void jpql_basic() {
		List resultList = em.createNamedQuery("query_get_all_courses").getResultList();
		//assertEquals("JPA in 50 steps", course.getName());
		logger.info("Select c from Course c ->{}",resultList);
	}
	
	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses",Course.class);
		List resultList = query.getResultList();
		//assertEquals("JPA in 50 steps", course.getName());
		logger.info("Select c from Course c ->{}",resultList);
	}
	
	@Test
	public void jpql_where() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where name like '%100 step%'",Course.class);
		List<Course> resultList = query.getResultList();
		//assertEquals("JPA in 50 steps", course.getName());
		logger.info("Select c from Course c where name like '%100 step' ->{}",resultList);
	}
	

}
