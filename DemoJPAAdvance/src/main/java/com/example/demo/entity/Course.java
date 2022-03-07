package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
//@Table(name="Course")
@NamedQuery(name="query_get_all_courses",query="Select c from Course c")
@Cacheable
@SQLDelete(sql = "update course set is_deleted=true where id=?")
@Where(clause = "is_deleted=false")
public class Course {
	@Id
	@GeneratedValue
	private Long id;
	
	//@Column(name="FullName", nullable=false)
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy = "course",fetch = FetchType.EAGER)
	private List<Review> reviews=new ArrayList<Review>();
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students=new ArrayList<Student>();
	
	
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	private boolean isDeleted;
	
	public Course() {
		
	}
	
	public Course(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	
	
	
	public List<Student> getStudens() {
		return students;
	}

	public void addStudens(Student student) {
		this.students.add(student);
	}

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}

}
