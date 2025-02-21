package com.company.java005_ex;

import java.util.Scanner;

public class Repeat002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 하나 입력 > ");
		int num = scanner.nextInt();
		switch(num) {
		case 1: System.out.println("1이다"); break;
		case 2: System.out.println("2이다");break;
		case 3: System.out.println("3이다");break;
		default: System.out.println("1,2,3이 아니다.");break;
		}
		scanner.close();
	}
}
