package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {

	@RequestMapping("/greet")
	public String greetUser(Model model) {
		model.addAttribute("message", "have a great day");
		return "success";
	}
	
	@RequestMapping("/sayHello")
	public String helloUser(Model model) {
		model.addAttribute("hellomessage", "hello there..!");
		return "success";
	}
	
	@RequestMapping("welcome")
	public ModelAndView welcomeUesr() {
		ModelAndView modelAndView=new ModelAndView("success", "mymessage", "welcome to mvc");
		return modelAndView;
	}
}
