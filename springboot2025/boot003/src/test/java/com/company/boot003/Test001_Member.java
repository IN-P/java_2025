package com.company.boot003;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.boot003.myjpa.Member;
import com.company.boot003.myjpa.MemberRepository;


@SpringBootTest
class Test001_Member {
	@Autowired MemberRepository mr;
	
	@Disabled //@Test
	public void insert() {
		Member mb = new Member();
		mb.setName("first");
		mb.setAge(11);
		mr.save(mb);
	}
	@Disabled //@Test
	public void selectAll() {
		List<Member> list = mr.findAll();
		for(Member m : list) {System.out.println(m.getId()+"/"+m.getName()+"/"+m.getAge()+"/"+m.getCreateDate());}
	}
	@Disabled //@Test
	public void update() {
	}
	@Disabled //@Test
	public void delete() {
	}

}
