package com.company.java003_ex;

import java.util.Scanner;

public class OperatorEx002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//q1
		System.out.print("정수를 입력 > ");
		int x = sc.nextInt();
		System.out.println(x>3&&x<10);
		
		//q2
		System.out.print("알파벳을 입력 > ");
		char ch = sc.next().charAt(0);
		System.out.println(ch=='a'||ch=='A');
		
		//q3
		System.out.print("숫자를 입력 > ");
		ch = sc.next().charAt(0);
		System.out.println(ch>='0'&&ch<='9');
				
		//q4
		System.out.print("문자를 입력 > ");
		ch = sc.next().charAt(0);
		System.out.println(((int)ch>=65&&(int)ch<=90)||((int)ch>=97&&(int)ch<=122));
	}

}
