package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.College;
import com.spring.repository.CollegeRepository;

@RestController
public class CollegeController {
	
	@Autowired
	private CollegeRepository collegeRepository;
	
	@GetMapping("/colleges")
	public List<College> getAllColleges(){
		return collegeRepository.findAllColleges();
	}
	
	

}
