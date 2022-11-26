package com.gl.project.College.service;

import java.util.List;
import com.gl.project.College.model.Student;




public interface StudentService {
	
	public List<Student> findAllStudent();
	public Student findById(int id); //Integer
	public Student save(Student student);
	public void deleteById(int id);
	public List<Student> search(String firstName, String lastName);


}
