package com.company.boot003.board;

import java.util.List;

import com.company.boot003.myjpa.Board;

public interface BoardService {
	public List<Board> findAll(); 			//전체리스트뽑고
	public Board find(Long id); 			//조회수올리고 / 상세보기
	public void insert(Board board);		//글쓰기기능
	public Board update_get(Long id);		//수정할글 가져오기
	public void update_post(Board board);	//수정하기기능
	public void delete_get(Board board);	//삭제기능
}
