package com.company.boot004.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MemberRepository extends JpaRepository<Member, Long>{
	Optional<Member> findByUsername(String username);
	
	@Modifying  
	@Transactional 
	@Query("update Member m set m.password = :password where m.id = :id and m.password = :old")
	int updateByIdAndPassword(@Param("id") Long id, @Param("password") String password, @Param("old") String old);
}
