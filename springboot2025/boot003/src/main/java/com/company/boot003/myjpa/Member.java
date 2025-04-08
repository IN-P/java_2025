package com.company.boot003.myjpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int age;
	@Column(nullable = false)
	private String name;
	
	@Column(updatable = false)
	private LocalDateTime createDate = LocalDateTime.now();
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
	List<Board> board = new ArrayList<>();
}
