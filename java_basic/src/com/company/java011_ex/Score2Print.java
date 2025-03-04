package com.company.java011_ex;

public class Score2Print {
	public void show(Score2[] std) {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("이름\t국어\t영어\t수학\t평균\t합격여부");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::");		
		for (Score2 s : std) {System.out.printf("%s\t%d\t%d\t%d\t%.2f\t%s\n"
				,s.getName(),s.getKor(),s.getEng(),s.getMath(),s.getAvg(),s.getPass());}
	}
}
