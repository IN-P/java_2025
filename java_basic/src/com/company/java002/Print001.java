package com.company.java002;

public class Print001 {
	public static void main(String[] args) {
		//1. System.out.println();
		System.out.println("1. 기본적으로 마지막에 줄바꿈");
		
		//2. System.out.print();
		System.out.print("2. 기본적으로 마지막에 줄바꿈 없음");
		System.out.print("- 줄바꿈은 printLn 사용.");
		
		//3. System.out.printf(); %d[정수] %f[실수] %s[문자] %.*f[소수점*개]
		System.out.printf("\n정수 %d, 실수 %.2f, 문자열 %s", 1, 3.14, "content");
		
		//4. + 의미
		System.out.println(10+3); // 숫자+숫자 연산
		System.out.println(10+3+"+"+1+2); //문자열이 나오는 순간 뒤에는 다 출력만함
		
		//Q. System.out.println(1+2=3);
		System.out.println(""+1+"+"+2+"="+3);
		System.out.println("1+2="+3);
		System.out.printf("%d%s%d%s%d",1,"+",2,"=",3);
		
		
		
	}
}
/*
*/