package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Review;

@Repository
@Transactional
public class CourseRepository {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	 @Autowired
	 EntityManager em;
	 public Course findById(Long id) {
		return em.find(Course.class, id);
		 
	 }
	 
	 public Course save(Course course) {
		 if(course.getId()==null) {
			 em.persist(course);
		 }else {
			 em.merge(course);
		 }
		return course;
		 
	 }
	 
	 public void deleteById(Long id) {
		 Course course=findById(id);
		 em.remove(course);
	 }
	 
	 public void playWithEntityManager() {
		 Course course1 = new Course("Web service course");
		 course1.setName("Web service course updated");
		 em.persist(course1);
		
		 
		 Course course2 = findById(10002L);
		 course2.setName("JPA in 100 steps NEW UPDATE");
		
		 
		// em.flush();
	//	Course course2 = new Course("Angular js course");
	//	em.persist(course2);
		//em.detach(course2);
		//em.clear();
	//	course1.setName("Web service course updated");
		//course2.setName("Angular js in 100 step course updated");
		
		
		//em.refresh(course1);
		//em.flush();
		 //logger.info("Play with Entity manger start");
	 }
	 
	 public void addReviewForCourse(Long courseId,List<Review> reviews) {
			// TODO Auto-generated method stub
		   Course course=findById(courseId);
		   logger.info("Course.getreviews->{}",course.getReviews());
		  
		   
		   for(Review review:reviews) {
		   
			   course.addReview(review);
			   review.setCourse(course);
			   
			   em.persist(review);
		   }
			
		}

	public void addHardCodedReviewForCourse() {
		// TODO Auto-generated method stub
	   Course course=findById(10001L);
	   logger.info("Course.getreviews->{}",course.getReviews());
	   
	   Review re1=new Review("Great hand-on stuff","5");
	   Review re2=new Review("Awesome","5");
	   
	   course.addReview(re1);
	   re1.setCourse(course);
	   course.addReview(re2);
	   re2.setCourse(course);
	   
	   em.persist(re1);
	   em.persist(re2);
		
	}
}
