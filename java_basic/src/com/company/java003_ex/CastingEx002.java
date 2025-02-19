package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx002 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int total=0;
		
		System.out.print("국어점수를 입력 ");
		int kor=scan.nextInt();
		System.out.print("영어점수를 입력 ");
		int eng=scan.nextInt();
		System.out.print("수학점수를 입력 ");
		int math=scan.nextInt();
		
		total=kor+eng+math;
		
		System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("::GOOD IT SCORE::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("국어\t영어\t수학\t총점\t평균\t레벨");
		System.out.printf("%d\t%d\t%d\t%d\t%.2f\t%d",kor,eng,math,total,total/3.0,total/30);
		scan.close();
	}

}
