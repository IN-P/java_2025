package com.company.java014;

import java.util.Scanner;

public class Exception001 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.print("1 입력 >");
			int num = scan.nextInt();
			if (num==1) break;
		}
	}
}
