package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class ParttimeEmployee extends Employee{
	
	protected ParttimeEmployee() {
		
	}
	
	public ParttimeEmployee(String name,BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage=hourlyWage;
	}
	private BigDecimal hourlyWage;

}
