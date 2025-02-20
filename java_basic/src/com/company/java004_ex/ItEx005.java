package com.company.java004_ex;

import java.util.Scanner;

public class ItEx005 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("영문자 한개를 입력 > ");
		char ch = scan.next().charAt(0);
		if(ch>='a'&&ch<='z') {System.out.println("변환 : "+(ch-=32));}
		else if(ch>='A'&&ch<='Z') {System.out.println("변환 : "+(ch+=32));}
		else {System.out.println("영문자가아닙니다.");}
		scan.close();
		
//		String result="영문자가아닙니다.";
//		if(ch>='a'&&ch<='z') {result=""+(ch-=32);}
//		else if(ch>='A'&&ch<='Z') {result=""+(ch+=32);}
//		System.out.println(result);
	}

}
