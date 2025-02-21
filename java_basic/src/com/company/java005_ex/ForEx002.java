package com.company.java005_ex;

import java.util.Scanner;

public class ForEx002 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("원하는 단을 입력 >");
		int num = scan.nextInt();
		for (int i=1;i<=9;i++) {System.out.println(""+num+"*"+i+"="+(num*i));}
		scan.close();
	}

}
