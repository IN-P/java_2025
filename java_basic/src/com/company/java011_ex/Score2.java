package com.company.java011_ex;

public class Score2 {
	private String name;
	private String pass;
	private int kor;
	private int eng;
	private int math;
	private double avg;
	
	public Score2(){}
	public Score2(String name,int kor,int eng,int math){
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	
	public String getPass() { return pass; } public void setPass(String pass) { this.pass = pass; }
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	public int getKor() { return kor; } public void setKor(int kor) { this.kor = kor; }
	public int getEng() { return eng; } public void setEng(int eng) { this.eng = eng; }
	public int getMath() { return math; } public void setMath(int math) { this.math = math; }
	public double getAvg() {return this.avg;} public void setAvg(double avg) {this.avg=avg;}
	
	@Override
	public String toString() {
		return "Score2 [name=" + name + ", pass=" + pass + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", avg="
				+ avg + "]";
	}
}
