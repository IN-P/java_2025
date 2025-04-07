package com.company.boot001.myjpa;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// name="USERNAME" 필드면 수정 NOT NULL 설정
	//@Column(name="USERNAME", nullable=false)
	@Column(nullable=false)
	private String name;
	
	private int age;
	
	@Column(updatable = false)
	private LocalDateTime createDate = LocalDateTime.now();
	
	@ManyToOne //외래키
	private Team team;
}
/*
관계1
 팀(avengers)은 많은 멤버(iron,hulk,,,,,,)를 가진다.
 멤버는 하나의 팀을 가진다.
 
 team -|-------∈ member
*/