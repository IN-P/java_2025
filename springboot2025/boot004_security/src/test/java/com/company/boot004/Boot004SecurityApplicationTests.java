package com.company.boot004;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.boot004.member.Member;
import com.company.boot004.member.MemberRepository;

@SpringBootTest
class Boot004SecurityApplicationTests {

	@Autowired MemberRepository mr;
	
	@Disabled //@Test
	public void insert() {
		Member mb = new Member();
		mb.setUsername("second");
		mb.setPassword("2");
		mb.setEmail("second@gmail.com");
		mr.save(mb);
	}
	@Disabled //@Test
	public void selectAll() {
		List<Member> list = mr.findAll();
		for(Member m : list) {System.out.println(m);}
	}
	@Disabled //@Test
	public void findUsername() {
		System.out.println(mr.findByUsername("first").get());
	}
	@Disabled //@Test
	public void update() {
		Optional<Member> find = mr.findById(1L);
		if(find.isPresent()) {
			Member mb = find.get();
			mb.setUsername(null);
			mb.setPassword(null);
			mb.setEmail(null);;
			mr.save(mb);
		}
	}
	@Disabled //@Test
	public void updatePassword() {
		mr.updateByIdAndPassword(2L,"22","2");
	}
	@Disabled //@Test
	public void delete() {
		Member mb = mr.findById(1L).get();
		mr.delete(mb);
	}
	
}
