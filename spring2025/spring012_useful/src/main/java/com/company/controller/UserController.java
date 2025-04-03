package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.dto.UserDto;
import com.company.service.UserService;

@Controller 
public class UserController {
	
	@Autowired UserService service;
	
	//@RequestMapping(value="/list.user", method=RequestMethod.GET)
	//@GetMapping("/list.user")
	@RequestMapping("/list.user")
	public String list(Model model) {
		model.addAttribute("list", service.selectAll()); //처리하고
		
		return "users/list"; //화면
		
	}
	
	//detail.user - GET 해당벙호 사용자정보 users/select.jsp
	@RequestMapping(value="/detail.user", method=RequestMethod.GET)
	public String detail(Model model, int no) {
		//System.out.println(no);
		model.addAttribute("dto",service.selectOne(no));
		return "users/select";
	}

	//insert.user - POST 글쓰기기능 list.jsp
	@RequestMapping(value="/insert.user", method=RequestMethod.POST)
	public String insert(UserDto dto) { //UserDto 안에 속성이 name,age
		if(dto!=null) {service.insert(dto);}
		return "redirect:/list.user";
	}
	
	//update.user - POST 글수정기능 사용자정보 list.jsp
	@RequestMapping(value="/update.user", method=RequestMethod.POST)
	public String update(UserDto dto) { //UserDto 안에 속성이 name,age
		if(dto!=null) {service.update(dto);}
		return "redirect:/list.user";
	}
	
	//delete.user - GET 삭제기능 사용자정보 list.jsp
	@RequestMapping(value="/delete.user", method=RequestMethod.GET)
	public String delete(Model model, int no) { //UserDto 안에 속성이 name,age
		model.addAttribute("dto",service.delete(no));
		return "redirect:/list.user";
	}
}
