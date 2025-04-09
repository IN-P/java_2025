package com.company.boot003.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.boot003.myjpa.Board;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	//ver-1 @Autowired BoardService sv;
	private final BoardServiceImpl sv;
	
	@GetMapping("/board/list")
	public String list(Model model){
		model.addAttribute("list", sv.findAll()); //전체리스트뽑고
		return "board/list"; // board 폴더안에 / list파일
	}// http://localhost:8080/board/list
	
	@GetMapping("/board/detail/{id}")
	public String detail(@PathVariable Long id, Model model){
		model.addAttribute("result",sv.find(id));//조회수올리고 /상세보기
		return "board/detail";
	}// http://localhost:8080/board/detail/1

	@GetMapping("/board/insert")
	public String insert_get(){
		return "board/insert";
	}// http://localhost:8080/board/insert (글쓰기 폼)
	
	@PostMapping("/board/insert")
	public String insert_post(Board bd, @RequestParam Long member_id){
		if(bd!=null) {sv.insert(bd,member_id);} //글쓰기 기능s
		return "redirect:/board/list";
	}// http://localhost:8080/board/list (글쓰기 기능 - 갱신된 리스트)__
	
	// @RequestParam 그냥넘길때
	// @PathVariable url 주소표시창으로 넘길때
	
	@GetMapping("/board/update/{id}")
	public String update_get(@PathVariable Long id, Model model){
		model.addAttribute("result", sv.update_get(id)); //수정할글 가져오기
		return "board/update";
	}// http://localhost:8080/board/update (글수정 폼)
	
	@PostMapping("/board/update")
	public String update_post(Board bd, RedirectAttributes rttr){
		String msg = "fail";
		if(sv.update_post(bd)>0) {msg="success";} //글삭제 기능
	    rttr.addFlashAttribute("msg", msg);
		return "redirect:/board/detail/"+bd.getId();
		
		//if(bd!=null) {sv.update_post(bd);} //글수정 기능
		//return "redirect:/board/detail/"+bd.getId();
	}// http://localhost:8080/board/detail (글수정 기능 - 갱신된 리스트)
	
	@GetMapping("/board/delete/{id}")
	public String delete_get(@PathVariable Long id, Model model){
		model.addAttribute("id",id);
		return "board/delete";
	}// http://localhost:8080/board/delete (글삭제 폼)
	
	@PostMapping("/board/delete")
	public String delete_post(Board bd, RedirectAttributes rttr){
		String msg = "fail";
		if(sv.delete(bd)>0) {msg="success";} //글삭제 기능
	    rttr.addFlashAttribute("msg", msg);
		//sv.delete(bd);
		return "redirect:/board/list";
	}// http://localhost:8080/board/delete (글삭제 기능 - 갱신된 리스트)
	
	
}
// Restful Api
// 기존게시판 : localhost:8080/board/detail?bno=10 쿼리스트링
// Restful Api : localhost:8080/board/detail/bno/10 쿼리스트링
// 	1) restful - http url 을 기반으로 자원에 접근해서 서비스를 제공하는 애플리케이션
//	2) api
//	3) method (GET:검색/POST:생성/PATCH(부분업데이트), PUT(전체업데이트)/DELETE(삭제))
//	4) DATA - json, xml