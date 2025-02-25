package com.company.java007_ex;

import java.util.Scanner;

public class Repeat002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("문자 한개 입력 > "); char ch=scanner.next().charAt(0);
		switch (ch) { 
		case 'a': System.out.println("apple"); break;
		case 'b': System.out.println("banana"); break;
		case 'c': System.out.println("coconut"); break;
		}
		scanner.close();
	}
}
