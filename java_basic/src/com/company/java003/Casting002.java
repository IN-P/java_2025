package com.company.java003;

import java.util.Scanner;

public class Casting002 {
	public static void main(String[] args) {
		//#1. 문자초기화
		char ch1 = ' '; //공백한개라도 있어야 함.
		char ch2 = '\u0000';
		
		System.out.println("step1 : "+ch1+"\t"+ch2);
		System.out.println("step2 : "+(int)ch1+"\t"+(int)ch2);
		
		//#2. 문자의 연산
		char c = 'A';
		System.out.println("step3 : "+c+"\t"+(int)c);
		System.out.println("step4 : "+(c+1));//66 
		System.out.println(c+1);//66 
		System.out.println("step4-1 : "+c+1);// 
		System.out.println("step5 : "+(char)(c+1)); 
		// 'A'+1 = 'A'(char | 2byte) + 1(int | 4byte) 사이즈큰걸로 계산
		// 결과물 int
		
		byte ex1 =1;
		// error) byte result1 = ex1+10; //byte(1) + int(4)
		// 해결) int result1 = ex1+10;
		// 해결) byte result1 = (byte) (ex1 + 10);
		
		//Q1 대문자'A'를 소문자'a'로 변환
		System.out.println("힌트 : "+'a'+"\t"+(int)'a');
		System.out.println((char)(c+32));
		char q1 ='A';
		System.out.println(q1+=32);
		
		//#3. 문자열
		// 자료형의 분류는 기본형(값)과 참조형(주소)
		String str1="abc";	//객체 사용시	str1 주소
		Scanner scan = new Scanner(System.in);	//scan 주소
		
		System.out.println(str1);
		System.out.println(scan);
		
		System.out.println(str1.charAt(0));	//a
		System.out.println(str1.charAt(1));	//b
		System.out.println(str1.charAt(2));	//c
		// char ch = scan.nextChar();  x
		String str = scan.next();
		System.out.println("입력한 문자열 : "+str);
		
		char ch = scan.next().charAt(0);
		System.out.println("입력한 문자 : "+ch);
		scan.close();
		//Q2. 대문자입력 받아서 소문자로 변경프로그램 - 클래스명 : CastingEx003.java
	}
}
