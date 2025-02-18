package com.company.java002;

public class Var001 {
	public static void main(String[] arge) {
		//자료형 변수명
		int a=0; // a[0]
		System.out.println("1 :"+a);
		
		a=100000;
		System.out.println("2 :"+a);
		
		a=100000-11000; // a[89000]
		System.out.println("3 :"+a);
		
		a-=3000; //a=a-3000;
		System.out.println("4 :"+a); //a[86000]
		
		//2. 변수의 범위 {여기서부터    }여기까지
		{int b=20; System.out.println(b);}
		//b=1000; b cannot be resolved to a variable
		
		//3. 변수명 $_소문자7
		int $1=1; int _2=2; int a3bc=3; 
		//int static; Syntax error on token "static", invalid VariableDeclarator
		//int package; int class; int void; (x)
		System.out.println($1+"\t"+2_2+"\t"+a3bc); //\t 탭
	}
}
