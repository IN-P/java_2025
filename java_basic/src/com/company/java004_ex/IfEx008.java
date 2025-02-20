package com.company.java004_ex;

import java.util.Scanner;

public class IfEx008 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("학번 입력 > ");String id = scan.next();
		System.out.print("국어점수 입력 > ");double kor = scan.nextDouble();
		System.out.print("수학점수 입력 > ");double math = scan.nextDouble();
		System.out.print("영어점수 입력 > ");double eng = scan.nextDouble();
		double total=kor+math+eng;
		double avg=total/3;
		String pass="합격",lv="수",good="";
		
		if(avg>=95) {good="장학생";}
		else if(avg>=80&&avg<95) {lv="우";}
		else if(avg>=70) {lv="미";if(kor<40||eng<40||math<40) {pass="불합격";}}
		else if(avg>=60) {lv="양";if(kor<40||eng<40||math<40) {pass="불합격";}}
		else {lv="가";pass="불합격";}
		
		System.out.println("=====================================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("=====================================================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s",id,(int)kor,(int)eng,(int)math,(int)total,avg,pass,lv,good);
		scan.close();
	}

}
