package com.company.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.BoardDao;
import com.company.dto.BoardDto;


@Service  // component-scan
public class BoardServiceImpl implements BoardService {
	@Autowired  BoardDao dao;   // ctrl + shift + o
	@Override public int insert(BoardDto dto) { 
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress()); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		
		return dao.insert(dto); 
	}
	@Override public int update(BoardDto dto) { return dao.update(dto); }
	@Override public BoardDto updateForm(int bno)  { return dao.select(bno); }
	@Override public int delete(BoardDto dto) {  return dao.delete(dto); }
	
	@Override public BoardDto detail(int bno) { dao.updateHit(bno); return dao.select(bno); }
	@Override public List<BoardDto> selectAll() { return dao.selectAll(); }
}
