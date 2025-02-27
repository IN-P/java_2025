package com.company.java009_ex;

import java.util.Scanner;

public class Repeat002 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("문자 하나 입력 > "); char ch=scan.next().charAt(0);
//		System.out.println(ch=='j'?"java":ch=='h'?"html":ch=='c'?"css":"");
		if(ch=='j') {
			System.out.println("java");
		}else if(ch=='h') {
			System.out.println("html");
		}else if(ch=='c') {
			System.out.println("css");
		}
		scan.close();
	}

}
