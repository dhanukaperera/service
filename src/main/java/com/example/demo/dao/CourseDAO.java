package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseDAO {
	
	@Autowired
	CourseRepository courseRepo;

	public Course save(Course course) {
		return courseRepo.save(course);
	}
	
	public Iterable<Course> getAll() {
		return courseRepo.findAll();
	}
	
	public Course findById(Integer id) {
		return courseRepo.findById(id).get();
	}
}
