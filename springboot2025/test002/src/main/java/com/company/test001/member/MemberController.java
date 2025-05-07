package com.company.test001.member;

import javax.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService ms;
	
	@GetMapping("/")
	public String main() {  return "member/login"; }

	@GetMapping("/member/member")
	public String member() {  return "member/member"; }
	
	@GetMapping("/member/login")
	public String login() {  return "member/login"; }
	
	@GetMapping("/member/join")
	public String join(MemberForm memberForm) {  return "member/join"; }
	
	@PostMapping("/member/join")
	public String join(@Valid MemberForm memberForm , BindingResult bindingResult) {  
		
		if(bindingResult.hasErrors()) { return "member/join"; }
		if( !memberForm.getPassword().equals(  memberForm.getPassword2()) ) {
			bindingResult.rejectValue("password2", "pawordInCorrect","패스워드를 확인해주세요");
			return "member/join"; 
		} 
		
		try {
			Member member = new Member();
			member.setUsername(  memberForm.getUsername() );
			member.setEmail(  memberForm.getEmail() );
			member.setPassword(  memberForm.getPassword() );
			ms.insertMember(member);
		}catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("failed" , "등록된 유저입니다.");
			return "member/join"; 
		} catch(Exception e) {
			e.printStackTrace();
			bindingResult.reject("failed" , e.getMessage());
			return "member/join"; 
		}
		
		return "member/login"; 
	}
	
	@GetMapping("/member/check-username")
	@ResponseBody
	public boolean checkUsername(@RequestParam String username) {
	    return ms.isUsernameDuplicate(username);
	}
}
