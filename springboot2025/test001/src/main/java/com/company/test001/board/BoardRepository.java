package com.company.test001.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	//id기준 내림차순 정리
	@Query("select b from Board b order by b.id desc")
	List<Board> findAllOrderByIdDesc();
	
	//id와 bpass가 같은면 삭제
	@Modifying 
	@Query("delete from Board b where b.id=:id and b.bpass=:bpass")
	int deleteByIdAndBpass(@Param("id") Long id, @Param("bpass") String bpass);
	
	//id와 bpass가 같은면 수정
	@Modifying 
	@Query("update Board b set b.btitle=:btitle, b.bcontent=:bcontent where b.id=:id and b.bpass=:bpass")
	int updateByIdAndBpass(@Param("id") Long id, @Param("bpass") String bpass,
			@Param("btitle") String btitle, @Param("bcontent") String bcontent);
	
	
}
