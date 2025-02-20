package com.company.java002_ex;

import java.util.Scanner;

public class DateTypeEx003 {

	public static void main(String[] args) {
		Scanner f = new Scanner(System.in);
		System.out.print("파이값을 입력하시오. >");
		System.out.printf("파이값은 %f입니다.",f.nextFloat());
		System.out.print("파이값은 "+f.nextFloat()+"입니다.");
		f.close();
	}

}
