package com.company.test001.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService bs;
	
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list",bs.findAllOrderByIdDesc());
		return "board/list";
	}
	
	@GetMapping("/detail/{id}")
	public String detail( @PathVariable  Long id,  Model model){
		model.addAttribute("dto" , bs.find(id)); 
		return "board/detail"; // board 폴더안에 / list파일
	}
	
	@GetMapping("/insert")
	public String insert_get(){ 
		return "board/write"; 
	}
	
	@PostMapping("/insert")
	public String insert_post(Board bd) {
		bs.insert(bd);
		return "redirect:/board/list";
	}
	
	@GetMapping("/update/{id}")
	public String update_get( @PathVariable Long id , Model model){ 
		model.addAttribute("dto",bs.selectById(id));
		return "board/edit"; 
	}
	
	@PostMapping("/update")
	public String update_post(Board bd, RedirectAttributes rttr){ 
		String msg = "fail";
		if(bs.update(bd)>0) { msg="success";}
		rttr.addFlashAttribute("msg", msg);
		return "redirect:/board/detail/" + bd.getId(); 
	} 
	
	@GetMapping("/delete/{id}")
	public String delete_get(@PathVariable Long id, Model model){
		model.addAttribute("id",id);
		return "board/delete"; 
	}
	
	@PostMapping("/delete")
	public String delete_post(Board board, RedirectAttributes rttr){ 
		String msg = "fail";
		if(bs.delete(board)>0) { msg="success";}
		rttr.addFlashAttribute("msg", msg);
		return "redirect:/board/list"; 
	}
}

