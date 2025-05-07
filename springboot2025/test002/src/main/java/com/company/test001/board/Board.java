package com.company.test001.board;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.company.test001.member.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "member")
public class Board {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200)
	private String btitle;
	
	@Column(columnDefinition = "text")
	private String bcontent;
	
	@Column(length = 255)
	private String bpass;
	
	private Long bhit=0L;
	
	private LocalDateTime create_date=LocalDateTime.now();
	
	@Column(length = 255)
	private String bip;
	
	@ManyToOne   
	@JoinColumn(name="member_id")
	private Member member;
}
