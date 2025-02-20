package com.company.java004_ex;

import java.util.Scanner;

public class IfEx002 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력 > ");
		double num = scan.nextDouble();
		if(num>0) {System.out.println("양수");}
		else if(num<0){System.out.println("음수");}
		else{System.out.println("zero");}
		scan.close();
	}

}
