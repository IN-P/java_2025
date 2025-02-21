package com.company.java005_ex;

import java.util.Scanner;

public class RepeatEx006_menu {
	public static void main(String[] args) {
		//1.변수
		Scanner scanner = new Scanner(System.in);
		int num=-1;
		
		//기능1) 2. 입력 3. 처리 4.출력
		for(;;) { //# 1-1 무한반복
			System.out.println("메뉴판입니다. 9. 종료> ");
			num = scanner.nextInt();
			if(num==9) {break;} // # 1-2 빠져나올조건	
		}
		scanner.close();
	}
}
