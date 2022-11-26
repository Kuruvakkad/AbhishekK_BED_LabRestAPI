package com.gl.project.College.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;
import com.gl.project.College.model.Student;
import com.gl.project.College.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/list")
	public String getAllStudents(Model model) {
		List<Student> student = studentService.findAllStudent();
		model.addAttribute("Student", student);
		return "index";

	}

	@RequestMapping("/showNewCustomerForm")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "new_student";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Student student = studentService.findById(id);
		model.addAttribute("Student", student);
		return "new_student";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("Student") Student student) {
		studentService.save(student);
		return "redirect:/students/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		studentService.deleteById(id);
		return "redirect:/studets/list";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			Model model) {
		if (!firstName.isEmpty() || !lastName.isEmpty()) {
			List<Student> student = studentService.search(firstName, lastName);
			model.addAttribute("Student", student);
			return "index";
		}
		return "redirect:/students/list";
	}

	/*
	 * @PostMapping("/save") public Student saveStudent(@RequestBody Student
	 * student) { return this.studentService.saveStudent(student); }
	 * 
	 * @GetMapping public Set<Student>fetchAllStudents(){ return
	 * this.studentService.fetchAllStudents(); }
	 * 
	 * @GetMapping("/{id}") public Student fetchStudentById(@PathVariable("id") int
	 * id) { return this.studentService.fetchStudentById(id); }
	 * 
	 * @DeleteMapping("/{id}") public void deleteStudentById(@PathVariable("id") int
	 * id) {
	 * 
	 * this.studentService.fetchStudentById(id);
	 * 
	 * }
	 * 
	 * /*@RequestMapping("/showNewCustomerForm") public String
	 * showNewCustomerForm(Model model) { Student student=new Student();
	 * model.addAttribute("Student", student); return "new_student"; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @RequestMapping("/showFormForUpdate") public String formForUpdate(Model
	 * model,@RequestParam("id") int id) { Student student =
	 * studentService.fetchStudentById(id); model.addAttribute("Student",student);
	 * return "new_student"; }
	 */

	

}
