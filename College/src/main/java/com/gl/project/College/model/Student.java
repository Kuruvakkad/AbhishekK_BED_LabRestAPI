package com.gl.project.College.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="student")
@Getter
@Setter
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="first_Name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="course")
	private String course;
	
	@Column(name="country  ")
	private String country;
	
	public Student() {}

	public Student(int id, String firstName, String lastName, String course, String country) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.country = country;
	}
	

}
