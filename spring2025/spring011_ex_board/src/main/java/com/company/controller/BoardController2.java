package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
@RequestMapping("/board")
public class BoardController2 {

	@RequestMapping(value="/list",method=RequestMethod.GET) 
	public String list() { 
		return "board/list";
	}
	@RequestMapping(value="/create",method=RequestMethod.GET) 
	public String create() { 
		return "board/write";
	}
	@RequestMapping(value="/create",method=RequestMethod.POST) 
	public String create_post() { 
		return "board/write";
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET) 
	public String detail() { 
		return "board/detail";
	}
	@RequestMapping(value="/edit",method=RequestMethod.GET) 
	public String edit() { 
		return "board/edit";
	}
	@RequestMapping(value="/edit",method=RequestMethod.POST) 
	public String edit_post() { 
		return "board/edit";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET) 
	public String delete() { 
		return "board/delete";
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST) 
	public String delete_post() { 
		return "board/delete";
	}
	


}
