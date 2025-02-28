package com.company.java010_ex;

class Score{
	String stdid; int kor,eng,math,total; double avg; 
	
	public Score() {}
	public Score(String stdid,int kor,int eng,int math) {
		this.stdid=stdid;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	
	void total() {this.total=this.kor+this.eng+this.math;}
	
	void avg() {this.avg=this.total/3.0;}
	
	void info() {
		total(); avg();
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f",this.stdid,this.kor,this.eng,this.math,this.total,this.avg);
		}
	
	
}

public class ClassEx006 {
	public static void main(String[] args) {
		Score  s1= new Score("std1234" , 100, 100 , 99 ); s1.info();
	}
}
