package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	@GeneratedValue
	private Long id;
	
	//@Column(name="FullName", nullable=false)
	@Column(nullable=false)
	private String number;	
	
	//private Student student;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Passport() {
		
	}
	
	public Passport(String number) {
		this.number=number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String name) {
		this.number = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Passport[%s]",number);//"Students [name=" + name + "]";
	}

}
