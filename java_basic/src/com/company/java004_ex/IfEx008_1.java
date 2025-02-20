package com.company.java004_ex;

import java.util.Scanner;

public class IfEx008_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int kor=0,eng=0,math=0,sum=0;
		double avg=0;
		String id="",pass="",lv="",good="";
		System.out.print("학번 입력 > ");id = scan.next();
		System.out.print("국어점수 입력 > ");kor = scan.nextInt();
		System.out.print("수학점수 입력 > ");math = scan.nextInt();
		System.out.print("영어점수 입력 > ");eng = scan.nextInt();
		
		sum=kor+math+eng;
		avg=sum/3.0;
		good=(avg>=95)?"장학생":"";
		lv=(avg>=90)?"수":(avg>=80)?"우":(avg>=70)?"미":(avg>=60)?"양":"가";
		pass=(avg>=60&&kor>=40&&eng>=40&&math>=40)?"합격":"불합격";
		
		System.out.println("=====================================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("=====================================================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s",id,kor,eng,math,sum,avg,pass,lv,good);
		scan.close();
	}

}
