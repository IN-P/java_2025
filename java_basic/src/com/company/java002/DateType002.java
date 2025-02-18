package com.company.java002;

import java.util.Scanner;

public class DateType002 {

	public static void main(String[] args) {
		//자료형의 분류 : 기본형 / 참조형
		// 기본형 : 논리형, 정수형(byte-short-int-long), 실수형(float-double)
		
		//OOP? : 클래스(부품객체)들을 조립해 완성해사는 프로그램
		int a=1; // 기본형
		Scanner scanner=new Scanner(System.in); //ctrl+shift+o
		//1. new 공간빌리기 heap 1000번지[   ]
		//2. Scanner(system.in) 사용할 수 있게 초기화 - 키보드로 입력
		//heap 1000번지[ [키보드로 입력받는기능] ] <- scanner [1000번지]
		
		System.out.println("좋아하는 숫자를 입력 >");
		a = scanner.nextInt();
		System.out.println("좋아하는 숫자는 : "+a);
	}

}
