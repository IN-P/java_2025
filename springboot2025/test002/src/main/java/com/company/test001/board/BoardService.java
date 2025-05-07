package com.company.test001.board;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardService {
	@Autowired BoardRepository br;
	
	//id 기준 내림차순정리
	public List<Board> findAllOrderByIdDesc(){
		return br.findAllOrderByIdDesc();
	}
	
	//insert
	public void insert (Board bd) {
		try { bd.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) { e.printStackTrace(); }
		br.save(bd);
	}
	
	//select
	public Board selectById(Long id) {
		Board bd = br.findById(id).get();
		br.save(bd);
		return bd;
	}
	//조회수증가
	public Board find(Long id) {
		Board bd = br.findById(id).get();
		bd.setBhit(bd.getBhit()+1);
		br.save(bd);
		return bd;
	}
	
	//update
	public int update(Board bd) {
		return br.updateByIdAndBpass( bd.getId(), bd.getBpass(), bd.getBtitle(), bd.getBcontent());
	}
	
	//delete
	public int delete(Board bd) {
		return br.deleteByIdAndBpass( bd.getId(), bd.getBpass());
	}
	
}
