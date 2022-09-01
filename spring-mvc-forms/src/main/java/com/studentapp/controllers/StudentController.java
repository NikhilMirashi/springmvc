package com.studentapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentapp.model.Student;

@Controller
public class StudentController {

//	@RequestMapping("/show")
//	public String printStudent(
//			@RequestParam("studentName") String name,
//			@RequestParam("city") String city,
//			@RequestParam("studentId") int studentId,Model model) {
//		
//		
//		//setvalues
//		
//		Student student =new Student();
//		student.setCity(city);
//		student.setStudentName(name);
//		student.setStudentId(studentId);
//		
//		model.addAttribute("myStudent",student);
//				return "success";
//		
//	}
	
	@RequestMapping(value="/show",method=RequestMethod.POST)
	public String printStudent(Student student) {
		return "success";
	}
	
}
