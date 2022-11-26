package com.gl.project.College.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.project.College.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(String firstName, String lastName);

}
