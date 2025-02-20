package com.company.java004_ex;

import java.util.Scanner;

public class ItEx004 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("문자한개를 입력 > ");
		char ch = scan.next().charAt(0);
		if(ch>='a'&&ch<='z') {System.out.println("소문자");}
		else if(ch>='A'&&ch<='Z') {System.out.println("대문자");}
		else {System.out.println("영문자가아님");}
		scan.close();
	}

}
