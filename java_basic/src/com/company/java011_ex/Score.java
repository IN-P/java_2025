package com.company.java011_ex;

public class Score {
	private String name,p,s,rank;
	private int kor=29,eng,math,total;
	private double aver;
	
	public Score(){}
	public Score(String name,int kor,int eng,int math){
		this.name=name; this.kor=kor; this.eng=eng; this.math=math;
	}
	
	public void setName(String name) {this.name=name;}
	public void setKor(int kor) {this.kor=kor;}
	public void setEng(int eng) {this.eng=eng;}
	public void setMath(int math) {this.math=math;}
	
	void calc() {
		this.total=this.kor+this.eng+this.math;
		this.aver=this.total/3.0;
		this.p=this.aver<60?"불합격":"합격";
		this.s=this.aver<95?"":"장학생";
		this.rank="★".repeat((int)aver/10);
	}
	
	public static void info() {
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	}
	
	public void show() {
		calc();
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n",this.name,this.kor,this.eng,this.math,this.total,this.aver,this.p,this.s,this.rank);
	}
}
