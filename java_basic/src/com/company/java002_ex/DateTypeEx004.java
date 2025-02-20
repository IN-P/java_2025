package com.company.java002_ex;

import java.util.Scanner;

public class DateTypeEx004 {

	public static void main(String[] args) {
		double lan, eg, math, sum, aver;
		Scanner scan = new Scanner(System.in);
		System.out.print("국어점수를 입력하시오. ");
		lan = scan.nextDouble();
		System.out.print("영어점수를 입력하시오. ");
		eg = scan.nextDouble();
		System.out.print("수학점수를 입력하시오. ");
		math = scan.nextDouble();
		sum=lan+eg+math;
		aver=sum/3;
		System.out.print("\n총점 : "+sum+"\n"+"평균 : "+aver);
		System.out.printf("\n총점 : %d\n평균 : %.2f",(int)sum,aver);
		scan.close();
		
	}

}
