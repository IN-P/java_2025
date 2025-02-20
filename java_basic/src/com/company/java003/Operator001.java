package com.company.java003;

import java.util.Scanner;

public class Operator001 {

	public static void main(String[] args) {
		//먼저() 값(+,-,*,/,%,++,--) 비교(<,>,<=,>=,==) 조건(&&,||,?:) 대입(=)
		//1. 값
		int a=10, b=3;
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
		System.out.println();
		
		//Q1. 나머지연산자 - 짝수홀수판정
		//Q2. 3의배수판정
		//2. 비교
		System.out.println(0%2+" "+1%2+" "+2%2+" "+3%2);
		System.out.println(0%3+" "+1%3+" "+2%3+" "+3%3);
		System.out.println(10>3);
		System.out.println(10<3);
		System.out.println(a%2==0);
		System.out.println(a%2==1);
		System.out.println(a%3==0);
		System.out.println(b%3==0);
		System.out.println();
		
		//3. 조건
		System.out.println(true&true);
		System.out.println(true&&true);
		System.out.println(false&true);	//& 처음도 false 뒤에조건까지 읽음
		System.out.println(false&&true);//Dead code
	
		System.out.println(true|true);	
		System.out.println(true||true); //Dead code
		System.out.println(false|true);	
		System.out.println(false||true);
		System.out.println();
		
		//4. ?: 삼항연산자
		System.out.println((a>b)?"a>b":"a<b");
		System.out.println((2%2==0)?"짝수":"홀수");
		System.out.println();
		//(조건)? 참:거짓
		//q1) 2의 배수이면서 5의 배수라면 true / false
		//q2) 2의 배수이거나 3의 배수라면 true / false
		//q3) 숫자를 입력 받아 0보다크면 양수, 0보다 작으면 음수, 아니라면 0
		
		System.out.println(a%2==0&&b%5==0);
		System.out.println(a%2==0||b%3==0);
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하시오.> ");
		double num = sc.nextDouble();
		System.out.println(num>0?"양수":num<0?"음수":"0");
		System.out.println();
		
		//5. 대입
		System.out.println(a+=b);
		System.out.println(a-=b);
		System.out.println(a*=b);
		System.out.println(a/=b);
		System.out.println(a%=b);
		System.out.println();
		
		//6. ++,-- (단항연산자)
		int a1=1, b1=1, c1=1, d1=1;
		System.out.println(++a1); //+1을 선연산
		System.out.println(a1);
		System.out.println(b1++); //+1을 후연산
		System.out.println(b1);
		System.out.println(--c1); //-1을 선연산
		System.out.println(c1);
		System.out.println(d1--); //-1을 후연산
		System.out.println(d1);
		
		
		
		
		
		
	}

}
