package com.company.java013_ex;

class Score{
	private String name;
	private int kor,eng,math;
	private int total;
	private double avg;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getKor() { return kor; }
	public void setKor(int kor) { this.kor = kor; }
	public int getEng() { return eng; }
	public void setEng(int eng) { this.eng = eng; }
	public int getMath() { return math; }
	public void setMath(int math) { this.math = math; }
	public int getTotal() { return total; }
	public void setTotal(int total) { this.total = total; }
	public double getAvg() { return avg; }
	public void setAvg(double avg) { this.avg = avg; }
}

class ScoreDto extends Score{
	ScoreDto(String name,int kor,int eng,int math){
		setName(name); setKor(kor);	setEng(eng); setMath(math);
	}
	private String jang;
	private String star;
	private String pass;
	
	public String getJang() { return jang; }
	public void setJang(String jang) { this.jang = jang; }
	public String getStar() { return star; }
	public void setStar(String star) { this.star = star; }
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }
}

abstract class Process{
	abstract double exec(int kor,int eng,int math);
	abstract double exec(int total);
	abstract String exec(double avg);
}

class Total extends Process{
	@Override double exec(int kor, int eng, int math) { return kor+eng+math; }
	@Override double exec(int total) { return 0; }
	@Override String exec(double avg) { return null; }
}
class Avg extends Process{
	@Override double exec(int kor, int eng, int math) { return 0; }
	@Override double exec(int total) { return total/3.0; }
	@Override String exec(double avg) { return null;}
}
class Jang extends Process{
	@Override double exec(int kor, int eng, int math) { return 0; }
	@Override double exec(int total) { return 0; }
	@Override String exec(double avg) { return avg<95?"":"장학생"; }
}
class Star extends Process{
	@Override double exec(int kor, int eng, int math) { return 0; }
	@Override double exec(int total) { return 0; }
	@Override String exec(double avg) { return "★".repeat((int)avg/10); }
}
class Pass extends Process{
	@Override double exec(int kor, int eng, int math) { return 0; }
	@Override double exec(int total) { return 0; }
	@Override String exec(double avg) { return avg<60?"불합격":"합격"; }
}

abstract class Print{
	abstract void show(ScoreDto std);
	abstract void show(ScoreDto[] std);
}

class StdPrint extends Print{
	@Override void show(ScoreDto std) { 
		Process total = new Total();
		Process avg = new Avg();
		Process jang = new Jang();
		Process star = new Star();
		Process pass = new Pass();
		//초기화해서 객체생성
		std.setTotal((int)total.exec(std.getKor(),std.getEng(),std.getMath()));
		std.setAvg(avg.exec(std.getTotal()));
		std.setJang(jang.exec(std.getAvg()));
		std.setStar(star.exec(std.getAvg()));
		std.setPass(pass.exec(std.getAvg()));
		//계산완료
		System.out.println("=============================================================================");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격\t장학생\t랭킹");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n"
				,std.getName(),std.getKor(),std.getEng(),std.getMath(),std.getTotal(),std.getAvg(),std.getPass(),std.getJang(),std.getStar());
		System.out.println("=============================================================================");
	}
	@Override void show(ScoreDto[] std) {  }
}

public class AbstractEx001 {
	public static void main(String[] args) {
		ScoreDto std = new ScoreDto("헐크",100,100,99);
		
		Process process = null;
		
		Print print = null;
		print = new StdPrint();
		print.show(std);
	}

}
