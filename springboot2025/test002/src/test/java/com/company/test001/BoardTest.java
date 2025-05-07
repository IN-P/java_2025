package com.company.test001;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.company.test001.board.Board;
import com.company.test001.board.BoardRepository;
import com.company.test001.board.BoardService;

@SpringBootTest
class BoardTest {
	@Autowired BoardRepository br;
	
	//board 생성
	@Disabled
	@Test
	public void insertBoard() {
		Board bd = new Board();
		bd.setBtitle("3");
		bd.setBpass("3");
		bd.setBcontent("3");
		try {
			bd.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		br.save(bd);
	}
	
	//id 기준 내림차순 정리
	@Disabled
	@Test
	public void findAllByIdDesc() {
		List<Board> bd = br.findAllOrderByIdDesc();
		for(Board b : bd) {
			System.out.println(b);
		}
	}
	
	//id와 bpass 같으면 수정
	@Disabled
	@Test
	@Transactional
	public void updateByIdAndBpass() {
		br.updateByIdAndBpass(3L, "3", "33", "33");
		System.out.println(br.findById(3L));
	}
	
	//id와 bpass 같으면 삭제
	@Disabled
	@Test
	@Transactional @Rollback(false)
	public void deleteByIdAndBpass() {
		int deleted = br.deleteByIdAndBpass(3L, "3");
		System.out.println(br.findById(3L));
		System.out.println("삭제된 행 수: " + deleted);
	}

	/////////////////////////////////////////
	// board service test
	/////////////////////////////////////////
	
	@Autowired BoardService bs;
	
	@Disabled
	@Test
	public void bsInsert() {
		Board bd = new Board();
		bd.setBtitle("4");
		bd.setBpass("4");
		bd.setBcontent("4");
		bs.insert(bd);
	}
	
	//@Disabled
	@Test
	public void bsfindAllByIdDesc() {
		List<Board> bd = bs.findAllOrderByIdDesc();
		for(Board b : bd) {
			System.out.println(b);
		}
	}
	
	@Disabled
	@Test
	public void bsselect() {
		Long id=4L;
		System.out.println(bs.selectById(id));
	}
	
	@Disabled
	@Test
	public void bsupdate() {
		Board bd = new Board();
		bd.setId(4L);
		bd.setBtitle("44");
		bd.setBpass("4");
		bd.setBcontent("44");
		bs.update(bd);
	}
	
	@Disabled
	@Test
	public void bsdelete() {
		Board bd = new Board();
		bd.setId(4L);
		bd.setBpass("4");
		bs.delete(bd);
	}
}
