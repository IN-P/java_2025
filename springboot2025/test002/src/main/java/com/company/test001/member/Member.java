package com.company.test001.member;

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

import com.company.test001.board.Board;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)  
	private String email;
	
	private String password;

	private LocalDateTime udate;

	@Column(unique=true)
	private String username;
	
	private LocalDateTime create_date = LocalDateTime.now();
	
	@OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
	List<Board> board = new ArrayList<>();
}
