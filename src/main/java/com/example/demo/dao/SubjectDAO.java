package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.Subject;
import com.example.demo.repository.SubjectRepository;

@Service
public class SubjectDAO {
	@Autowired
	SubjectRepository subjectRepo;
	
	public Subject add(Subject sub) {
		return subjectRepo.save(sub);
	}
	
	public Iterable<Subject> getAll() {
		return subjectRepo.findAll();
	}
	 
	public List<Course> findSubjectsByCourse(Integer cid) {
		List<Subject> sList = subjectRepo.findAll();
		List<Course> cc = new ArrayList<>();
		for (Subject element : sList) {
		   Course c =  element.getCourse();
		   if(c.getId() == cid) {
			   cc.add(c);
		   }
		}
		return cc;
	}
	

}
