package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Student;
import com.app.service.IStudentService;

@Component
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private IStudentService service;
	
	@RequestMapping("/reg")
	public String showRegisterPage(ModelMap map) {
		map.addAttribute("student", new Student());
		return "StudentRegister";
	}

}
