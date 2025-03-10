package com.company.java015_ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

class Score{
	String name;
	int kor,eng,math,total;
	double avg;
	
	public Score() { super(); }
	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor+eng+math;
		this.avg = this.total/3.0;
	}
	
	void show () {
		System.out.println("이름 : "+this.name);
		System.out.println("국어 : "+this.kor);
		System.out.println("영어 : "+this.eng);
		System.out.println("수학 : "+this.math);
		System.out.println("총점 : "+this.total);
		System.out.println("평균 : "+String.format("%.2f",this.avg));
		System.out.println();
	}
	
	@Override public int hashCode() { return Objects.hash(name); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return Objects.equals(name, other.name);
	}
}

public class SetEx004 {
	public static void main(String[] args) {
		Set<Score> scores = new HashSet<>();
		
		scores.add(new  Score("아이언맨",30,40,50)); 
		scores.add(new  Score("아이언맨",30,40,50)); 
		scores.add(new  Score("아이언맨",30,40,50)); 
		scores.add(new Score("헐크"   ,40,60,70)); 
		scores.add(new  Score("캡틴",80,90,100));
		
		//System.out.println(scores.size()); 사이즈 확인
		
		Iterator<Score> iter = scores.iterator();
		while(iter.hasNext()) {
			Score temp = iter.next();
			temp.show();
		}
		
	}
}
