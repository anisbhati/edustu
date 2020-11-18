package com.example.edu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.edu.model.Student;
import com.example.edu.service.DataService;

@RestController
public class ServiceController {
	@Autowired
	DataService d;
	
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
}
