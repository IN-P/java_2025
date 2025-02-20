package com.company.java002;

import java.util.Scanner;

public class DateType003 {

	public static void main(String[] args) {
		//gigo - 변수 - 입력 - 처리 - 출력
		//변수
		float f =3.14f; double d =3.14;
		Scanner scan = new Scanner(System.in);
		//입력
		System.out.print("실수를 입력하세요.");
		d=scan.nextDouble();
		//처리
		
		//출력
		System.out.println("입력하신값은?"+d);
	}

}
