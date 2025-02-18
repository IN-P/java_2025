package com.company.java002_ex;

import java.util.Scanner;

public class DateTypeEx002 {

	public static void main(String[] args) {
//		int num=0;
//		Scanner scan = new Scanner(System.in);
//		System.out.print("좋아하는 수(정수)를 입력하시오. >");
//		num = scan.nextInt();
//		System.out.printf("좋아하는 숫자는 %d입니다.", num);
//		scan.close();
		//int 값은 -2,147,483,648 ~ 2,147,483,647
		
		Scanner c = new Scanner(System.in);
		System.out.print("좋아하는 수(정수)를 입력하시오. >");
		System.out.print("좋아하는 숫자는 "+c.nextInt()+"입니다.");
		c.close();
		
	}

}
