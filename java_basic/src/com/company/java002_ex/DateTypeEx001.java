package com.company.java002_ex;

import java.util.Scanner;

public class DateTypeEx001 {

	public static void main(String[] args) {
//		int age=0;
//		Scanner scanner=new Scanner(System.in);
//		System.out.print("당신의 나이를 입력하시오 > ");
//		age = scanner.nextInt();
//		System.out.println("당신의 나이는 "+age+"입니다.");

//		Scanner scanner=new Scanner(System.in);
//		System.out.print("당신의 나이를 입력하시오 > ");
//		int age=scanner.nextInt();
//		System.out.println("당신의 나이는 "+age+"입니다.");
//		scanner.close();
		
		Scanner age = new Scanner(System.in);
		System.out.print("당신의 나이를 입력하시오 > ");
		System.out.println("당신의 나이는 "+age.nextInt()+"입니다.");
		age.close();

	}

}
