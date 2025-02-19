package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx001 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		System.out.print("숫자입력1> ");
		int a=scan.nextInt();
		System.out.print("숫자입력2> ");
		int b=scan.nextInt();
		
		System.out.println(a+"/"+b+"="+String.format("%.2f", (float)a/b));
									//String.format("출력서식", 처리할값);
		System.out.printf("%d %s %d %s %.2f",a,"/",b,"=",(float)a/b);
		scan.close();

	}

}
