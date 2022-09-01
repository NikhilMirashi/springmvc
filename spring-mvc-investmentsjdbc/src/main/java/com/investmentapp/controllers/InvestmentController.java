package com.investmentapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.investmentapp.model.Investment;
import com.investmentapp.service.IInvestmentService;

@Controller
public class InvestmentController {

	IInvestmentService investmentService;

	@Autowired
	public void setInvestmentService(IInvestmentService investmentService) {
		this.investmentService = investmentService;
	}

	@RequestMapping("/")
	public String homePage(Model model) {
		List<Investment> investments = investmentService.getAll();
		model.addAttribute("investments", investments);
		return "index";
	}

	@RequestMapping("/admin")
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/addForm")
	public String addFormPage() {
		return "addformpage";
	}

	

	
	
	

	// Add Investment

	@RequestMapping(value = "/addInvestment", method = RequestMethod.POST)
	public String addInvestment(@Valid Investment investment, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/";
		}
		investmentService.addInvestment(investment);
		return "admin";
	}
	
	@RequestMapping("/updateForm")
	public String updateFormPage() {
		return "editformpage";
	}
	
	@RequestMapping("/getOne")
	public String getById(@RequestParam("planId") int planId,Model model) {
		Investment investment=investmentService.getById(planId);
		model.addAttribute("investment", investment);
		return "updateformpage";
	}
	
	@RequestMapping("/updateInvestment")
	public String updateInvestment(Investment investment,Model model) {
		System.out.println(investment);
		investmentService.updateInvestment(investment.getPlanId(), investment.getAmount());
		return "admin";
	}
	
	@ExceptionHandler(Exception.class)
	public String handlerException(Exception e,Model model) {
		System.out.println("Exception...");
		model.addAttribute("error", "error occured");
		return "admin";
	}
	
	@RequestMapping("/deleteForm")
	public String deleteFormPage() {
		return "deleteformpage";  //this is the file name
	}

}
