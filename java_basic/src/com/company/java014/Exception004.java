package com.company.java014;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception004 {
	public static int nextInt() throws InputMismatchException{
		int a=-1;
		Scanner scan = new Scanner(System.in);
		System.out.print("1 입력 >");
		a = scan.nextInt();
		return a;
	}
	
	public static void main(String[] args) /*throws Exception*/ {
		int a=-1;
		while (true) {
			try{
				a=nextInt();
				if(a==1) break;
			}catch(Exception e) {
				System.out.println("에러");
			}
		}
	}
}
