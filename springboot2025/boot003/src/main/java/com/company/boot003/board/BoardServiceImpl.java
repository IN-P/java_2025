package com.company.boot003.board;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.boot003.myjpa.Board;
import com.company.boot003.myjpa.BoardRepository;
import com.company.boot003.myjpa.Member;

@Service
public class BoardServiceImpl /*implements BoardService*/ {

	@Autowired BoardRepository br;
	
	/*@Override*/
	public List<Board> findAll() {
		//return br.findAll();
		return br.findAllByOrderByDesc();
	}
	
	@Transactional // commit(반영) / rollback(되돌리기)
	/*@Override*/
	public Board find(Long id) {
		Board bd = br.findById(id).get();
		bd.setBhit(bd.getBhit()+1); // 조회수 +1
		br.save(bd);
		return bd;
	}

	/*@Override*/
	public void insert(Board bd, Long member_id) {
		Member mb = new Member();
		mb.setId(member_id);
		bd.setMember(mb);
		bd.setBip();
		br.save(bd);
	}

	/*@Override*/
	public Board update_get(Long id) {
		return br.findById(id).get();
	}

	/*@Override*/
	public int update_post(Board bd) {
		return br.updateByIdAndBpass(bd.getId(),bd.getBpass(),bd.getBtitle(), bd.getBcontent());
	}

	/*@Override*/
	public int delete(Board bd) {
		//br.delete(bd);
		return br.deleteByIdAndBpass(bd.getId(), bd.getBpass()); 
	}

}
