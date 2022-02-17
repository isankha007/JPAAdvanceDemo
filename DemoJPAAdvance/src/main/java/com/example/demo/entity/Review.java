package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	
	private String rating;
	
	//@Column(nullable=false)
	private String descriptions;	
	
	public Review() {
		
	}
	
	public Review(String descriptions,String rating) {
		this.rating=rating;
		this.descriptions=descriptions;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Review[%s %s]",descriptions,rating);//"Students [name=" + name + "]";
	}

}
