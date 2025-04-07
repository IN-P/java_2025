package com.company.boot001.myjpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Team {
	@Id // 1. 기본키 primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 2. 숫자자동증가 auto_increment
	private Long id;
	
	private String name;
	
	@Column(updatable = false) //수정못하게
	private LocalDateTime createDate = LocalDateTime.now();
	
	//@Transient //컬럼 인식 못하게
	//private String email;
	
	@OneToMany
	List<Member> member = new ArrayList<>();
	
}
