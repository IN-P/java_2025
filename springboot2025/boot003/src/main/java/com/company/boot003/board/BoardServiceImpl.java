package com.company.boot003.board;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.boot003.myjpa.Board;
import com.company.boot003.myjpa.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardRepository br;
	
	@Override
	public List<Board> findAll() {
		return br.findAll();
	}
	
	@Transactional // commit(반영) / rollback(되돌리기)
	@Override
	public Board find(Long id) {
		Board bd = br.findById(id).get();
		bd.setBhit(bd.getBhit()+1); // 조회수 +1
		br.save(bd);
		return bd;
	}

	@Override
	public void insert(Board bd) {
		bd.setBip();
		br.save(bd);
	}

	@Override
	public Board update_get(Long id) {
		return br.findById(id).get();
	}

	@Override
	public void update_post(Board bd) {
		br.save(bd);
	}

	@Override
	public void delete_get(Board bd) {
		br.delete(bd);
	}

}
