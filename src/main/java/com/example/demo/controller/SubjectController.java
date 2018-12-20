package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CourseDAO;
import com.example.demo.dao.SubjectDAO;
import com.example.demo.model.Course;
import com.example.demo.model.Subject;

@RestController
@RequestMapping(path = "/api/subject")
public class SubjectController {
	@Autowired
	SubjectDAO subjectDAO;
	@Autowired
	CourseDAO courseDAO;
	
	@PostMapping(path="/add")
	public Subject add(@RequestParam String name, @RequestParam Integer courseId ) {
		Course c = courseDAO.findById(courseId);
		Subject s = new Subject();
		s.setName(name);
		s.setCourse(c);
		subjectDAO.add(s);
		return s;
	}
	
	@GetMapping(path="/all")
	public Iterable<Subject> getAll() {
		return subjectDAO.getAll();
	}
	
	@GetMapping(path="/getsubs/{id}")
	public Iterable<Course> getSubsByCourse(@PathVariable(value="id")Integer id) {
		return subjectDAO.findSubjectsByCourse(id);
	}

}
