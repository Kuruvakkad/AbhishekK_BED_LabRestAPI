package com.gl.project.College.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.project.College.model.Student;
import com.gl.project.College.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	
	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public List<Student> search(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return studentRepository.findByFirstNameContainsAndLastNameContainsAllIgnoreCase(firstName, lastName);
	}

}
