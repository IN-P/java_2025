package com.company.boot003;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.boot003.myjpa.Board;
import com.company.boot003.myjpa.BoardRepository;
import com.company.boot003.myjpa.Member;


@SpringBootTest
class Test002_Board {
	@Autowired BoardRepository br;
	
	@Disabled //@Test
	public void insert() {
		Member mb = new Member();
		mb.setId(1L);
		Board bd = new Board();
		bd.setBtitle("one1");
		bd.setBcontent("two1");
		bd.setBpass("2");
		bd.setMember(mb);
		br.save(bd);
	}
	@Test
	public void selectAll() {
		List<Board> list = br.findAll();
		for(Board b : list) {System.out.println(b);}
	}
	@Disabled //@Test
	public void update() {
		Optional<Board> find = br.findById(2L);
		if(find.isPresent()) {
			Board bd = find.get();
			bd.setBtitle("안녕");
			bd.setBpass("222");
			bd.setBfile(null);;
			bd.setBcontent("하살법");
			br.save(bd);
		}
	}
	@Disabled //@Test
	public void delete() {
		Optional<Board> find = br.findById(2L);
		if(find.isPresent()) {
			Board bd = find.get();
			br.delete(bd);
		}
	}

}
