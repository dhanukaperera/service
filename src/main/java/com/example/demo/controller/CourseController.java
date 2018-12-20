package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CourseDAO;
import com.example.demo.model.Course;

@RestController
@RequestMapping(path="api/course")
public class CourseController {
	
	@Autowired
	CourseDAO courseDAO;
	
	@PostMapping("/new")
	public Course add(@RequestParam String name) {
		Course c = new Course();
		c.setName(name);
		return courseDAO.save(c);
	}
	
	@GetMapping(path="/all")
	public Iterable<Course> getAll() {
		return courseDAO.getAll();
	}

}
