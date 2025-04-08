package com.company.boot003.myjpa;

import java.net.InetAddress;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Board {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Lob //sql타입을 text로 변환
	@Column(columnDefinition = "text")//위와 동일
	private String bcontent;
	private String bfile;
	private Long bhit=0L;
	
	@Column(updatable = false)
	private String bip; 
	private String bpass;
	
	@Column(length=200) //문자열 200자
	private String btitle;
	@Column(updatable = false)
	private LocalDateTime createDate = LocalDateTime.now();
	
	@ManyToOne //외래키
	@JoinColumn(name="MEMBER_ID")
	private Member member;
	
	public void setBip() {
		try {
			this.bip = InetAddress.getLocalHost().getHostAddress();
		} catch(Exception e) {
			e.printStackTrace();
			this.bip = null;
		}
	}
	
}
