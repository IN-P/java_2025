package com.company.boot001;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.boot001.myjpa.Team;
import com.company.boot001.myjpa.TeamRepository;

@SpringBootTest
class Test001_Team {
	@Autowired TeamRepository teamRepository;
	
	// teamRepository.save (insert,update) /delete-(delete)
	// teamRepository.findAll(select) / findById (select)
	@Disabled //@Test
	void insert() {
		Team team = new Team();
		team.setName("avengers");
		teamRepository.save(team);
	}
	@Disabled //@Test
	void selectAll() {
		List<Team> list = teamRepository.findAll();
		System.out.println(list.size());
		System.out.println(list.get(0).getName());
	}
	@Disabled //@Test
	public void update() {
		//1. 수정할 팀찾기
		//Optional<Team> - null값 안정보장
		Optional<Team> findTeam = teamRepository.findById(1L);
		System.out.println(findTeam.isPresent()); //존재하는지 질문 true
		
		//2. 이름변경해서 수정
		Team team = findTeam.get();
		team.setName("avengers");
		teamRepository.save(team); // save : insert , update
	} 
	@Disabled //@Test
	public void delete() {
		Optional<Team> findTeam = teamRepository.findById(2L);
		Team team = findTeam.get();
		teamRepository.delete(team);
	}
	

}
//crud1. insert into team (name) values (?)
//crud2. select * from team / select * from team where id=?
//crud3. update team set name=? where id=?
//crud3. delete from team where id=?
