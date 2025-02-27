package com.company.java009_ex;

import java.util.Scanner;

public class Repeat001 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("문자 하나 입력 > "); char ch=scan.next().charAt(0);
		
		switch(ch) {
		case 'j': System.out.println("java"); break;
		case 'h': System.out.println("html"); break;
		case 'c': System.out.println("css"); break;
		}
		scan.close();
	}

}
