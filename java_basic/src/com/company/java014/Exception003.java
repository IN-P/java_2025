package com.company.java014;

import java.util.Scanner;

public class Exception003 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num=0;
		while(true){
			System.out.print("1 입력 >");
			try{
				num = scan.nextInt();
				if (num==1) break;
			} catch(Exception e) {
				scan.next();
				System.out.println("숫자만입력하렴");
			}
		}
	}
}
