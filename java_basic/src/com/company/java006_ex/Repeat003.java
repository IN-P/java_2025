package com.company.java006_ex;

import java.util.Scanner;

public class Repeat003 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 한개 입력 > ");
		int a = scan.nextInt();
		if(a==10) {System.out.println("10이다.");}
		else if(a==20) {System.out.println("20이다.");}
		else if(a==30) {System.out.println("30이다.");}
		scan.close();
	}

}
