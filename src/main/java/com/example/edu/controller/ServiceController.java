package com.example.edu.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.edu.model.Student;
import com.example.edu.repository.StudentRepository;
import com.example.edu.service.DataService;

@RestController
public class ServiceController {
	@Autowired
	DataService d;
	
	@Autowired
	StudentRepository s;
	
	@PostMapping("/addStudeny")
	public String addStudent(@RequestBody Student s) {
		return d.addStudent(s);
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent(){
		return d.getAllStudent();
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "service working ........";
	}
    // this for testing purpose
	
	@GetMapping("/getStudent/{id}")
	public Optional<Student> getStudetnById(@PathVariable("id") int id) {
		Optional<Student> ss=s.findById(id);
		return ss;
	}
	
	@DeleteMapping("/getStudent/{id}")
	public String deleteStudetnById(@PathVariable("id") int id) {
		try {
		s.deleteById(id);
		return id+" is deleted ...";
		}catch (Exception e) {
			return "something went wrong ...";
		}
		
		
	}
}
