package com.company.java004_ex;

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int result=0;
		System.out.print("1. 정수 하나를 입력해주세요. > ");
		int num1 = scan.nextInt();
		System.out.print("2. 정수 하나를 입력해주세요. > ");
		int num2 = scan.nextInt();
		System.out.print("3. 연산자 하나를 입력해주세요.(+,-,/,*) > ");
		char operator = scan.next().charAt(0);
		
		if(operator=='+') {result=num1+num2;}
		else if(operator=='-') {result=num1-num2;}
		else if(operator=='*') {result=num1*num2;}
		else if(operator=='/') {result=num1/num2;}
		else {System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");}
		System.out.println(""+num1+operator+num2+"="+result);
		System.out.printf("%d%s%d=%d",num1,operator,num2,result);
		
		scan.close();
	}

}

//연습문제7)  ※ 숙제
//패키지명 : com.company.java004_ex
//클래스명 :  IfEx007
//출력내용 :  계산기
//
//1. 정수를 하나 입력해주세요 > 10
//2. 정수를 하나 입력해주세요 > 3
//3. 연산자를 입력해주세요(+,-,*,/) > +
//10+3=13
//
//1. 정수를 하나 입력해주세요 > 10
//2. 정수를 하나 입력해주세요 > 3
//3. 연산자를 입력해주세요(+,-,*,/) > -
//10-3=7