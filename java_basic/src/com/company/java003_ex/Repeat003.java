package com.company.java003_ex;

import java.util.Scanner;

public class Repeat003 {

	public static void main(String[] args) {
		//변수
		double kor, eng, math, total, average;
		Scanner scan = new Scanner(System.in);
		//입력
		System.out.print("국어점수를 입력하시오. ");
		kor=scan.nextDouble();
		System.out.print("영어점수를 입력하시오. ");
		eng=scan.nextDouble();
		System.out.print("수학점수를 입력하시오. ");
		math=scan.nextDouble();
		//처리
		total=kor+eng+math;
		average=total/3;
		//출력
		System.out.printf("\n총점 : %d\n평균 : %.2f",(int)total,average);
		scan.close();
	}

}
