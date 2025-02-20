package com.company.java004_ex;

import java.util.Scanner;

public class IfEx001 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("평균 입력 > ");
		double avg = scan.nextDouble();
		String result="불합격";
		if(avg>=60) {System.out.println("합격"); result="합격";}
		else{System.out.println("불합격");}
		System.out.println(result);
		//변수 하나 생성을 더해서 if문에 변경하도록 구조도 있음.
		scan.close();
	}

}
