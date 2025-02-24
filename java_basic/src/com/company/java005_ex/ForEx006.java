package com.company.java005_ex;

import java.util.Scanner;

public class ForEx006 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1=-1,num2=-1;
		double result=0;
		char ch='a';
		//#todo1 숫자1입력받고 잘못썻으면 다시 입력받기
		//#todo1 숫자2입력받고 잘못썻으면 다시 입력받기
		//#todo1 연산자입력받고 잘못썻으면 다시 입력받기
		// true: 실행안하고 false: 실행하도록 if 구조 굳굳
		for (;;) {
			if (num1<0||num1>100) {
				System.out.print("숫자1 입력 > "); num1=scan.nextInt();
			} else if (num2<0||num2>100) {
				System.out.print("숫자2 입력 > "); num2=scan.nextInt();
			} else if (ch!='+'&&ch!='-'&&ch!='*'&&ch!='/') {
				System.out.print("연산자 입력 > "); ch=scan.next().charAt(0);
			} else {scan.close(); break;}
		}
		
		switch (ch) {
		case '+': result=num1+num2; break;
		case '-': result=num1-num2; break;
		case '*': result=num1*num2; break;
		case '/': result=(float)num1/num2; break;
		}
		
		System.out.println(""+num1+ch+num2+"="+(ch!='/'? (int)result:String.format("%.2f", result)));	
	}

}
