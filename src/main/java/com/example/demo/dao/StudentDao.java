package com.example.demo.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentDao {
	@Autowired
	StudentRepository studentRepo;
	
	// Save a Student
	public Student save (Student student) {
		return studentRepo.save(student);
	}
	
	// Find all Students
	public Iterable<Student> findAll() {
		return studentRepo.findAll();
	}
	
	// Get a student by id
	public Student findById(Long studentId) {
		return  studentRepo.findById(studentId).get();
	}
	
	// Delete a student
	public void delete (Student student) {
		studentRepo.delete(student);
	}
}
