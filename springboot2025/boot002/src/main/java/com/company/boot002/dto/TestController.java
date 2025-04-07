package com.company.boot002.dto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/ex1")
	@ResponseBody
	public String ex1() {return "springboot";}
	
	@GetMapping("/ex2")
	//@RequestMapping("/ex2")
	public String ex2(Model model) {
		model.addAttribute("result","ex2");
		return "ex2";
	}
	
	@RequestMapping("/test")
	public String test() {return "test";}
	
}
