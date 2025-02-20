package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx003 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("대문자를 입력해주세요. >");
		char ch = scan.next().charAt(0);
		System.out.println(ch+=32);
	}

}
