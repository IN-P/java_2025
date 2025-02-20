package com.company.java004_ex;

import java.util.Scanner;

public class IfEx006 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력 > ");
		int num = scan.nextInt();
		String sex="남자";
		if(num%2==0) {sex="여자";}
		System.out.println("성별은 "+sex);
		scan.close();
	}
}
