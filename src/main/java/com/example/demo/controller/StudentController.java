package com.example.demo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Course;
import com.example.demo.model.Student;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentDao studentDAO;
	
	// save student end point
	@PostMapping(path="/save")
	public Student createStudent(@Valid @RequestBody Student std) {
		return studentDAO.save(std);
	}
	
	// get all the students 
	@GetMapping(path="/all")
	public Iterable<Student> getAllStudents() {
		return studentDAO.findAll();
	}
	
	// get student by id
	@GetMapping(path="/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Long id){
		Student std = studentDAO.findById(id);
		
		if (std == null ) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(std);
	}
	
	// update a student by student id
	@PutMapping(path="/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value="id") Long id, @Valid @RequestParam String name, @RequestParam Integer age) {
		Student std = studentDAO.findById(id);
		
		if (std == null ) {
			return ResponseEntity.notFound().build();
		}
		
		std.setName(name);
		std.setAge(age);
		
		Student updatedStd = studentDAO.save(std);
		return ResponseEntity.ok().body(updatedStd);
 
	}
	
	// delete student by id
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable(value="id") Long id) {
		Student std = studentDAO.findById(id);
		
		if (std == null ) {
			return ResponseEntity.notFound().build();
		}
		
		studentDAO.delete(std);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping(path="/new")
	public @ResponseBody Student  addNewUser(@RequestParam String name, @RequestParam Integer age) {
		Student s = new Student();
		s.setName(name);
		s.setAge(age);
		studentDAO.save(s);
		return s;
	}
	
	
	
}
