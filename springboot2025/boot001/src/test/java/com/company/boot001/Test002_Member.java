package com.company.boot001;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.boot001.myjpa.Member;
import com.company.boot001.myjpa.MemberRepository;
import com.company.boot001.myjpa.Team;

@SpringBootTest
class Test002_Member {
	@Autowired MemberRepository mr;
	
	// teamRepository.save (insert,update) /delete-(delete)
	// teamRepository.findAll(select) / findById (select)
	@Disabled //@Test
	public void insert() {
		Team team = new Team();
		team.setId(1L);
		Member member = new Member();
		member.setName("second");
		member.setAge(22);
		member.setTeam(team);
		mr.save(member);
	}
	@Disabled //@Test
	public void selectAll() {
		List<Member> list = mr.findAll();
		System.out.println(list.size());
		for(Member m : list) {
			System.out.println(m.getId()+"/"+m.getName()+"/"+m.getAge()+"/"+m.getCreateDate());
		}
	}
	@Disabled //@Test
	public void update() {
		//1. 수정할 팀찾기
		//Optional<Team> - null값 안정보장
		Optional<Member> findMember = mr.findById(1L);
		if(findMember.isPresent()) {
			Member member = findMember.get();
			//2. 이름변경해서 수정
			member.setName("first_update");
			member.setAge(111);
			mr.save(member); // save : insert , update
		}
		
	} 
	@Disabled //@Test
	public void delete() {
		Optional<Member> findMember = mr.findById(1L);
		if(findMember.isPresent()) {
			Member member = findMember.get();
			mr.delete(member);
		}
	}
	

}
//crud1. insert into team (name) values (?)
//crud2. select * from team / select * from team where id=?
//crud3. update team set name=? where id=?
//crud3. delete from team where id=?
