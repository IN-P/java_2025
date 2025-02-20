package com.company.java002_ex;

public class VarEx002 {

	public static void main(String[] args) {
//		float a=10; float b=3;
//		System.out.println(a+"+"+b+"="+(a+b));
//		System.out.println(a+"-"+b+"="+(a-b));
//		System.out.println(a+"*"+b+"="+(a*b));
//		System.out.println(a+"/"+b+"="+(a/b));
//		System.out.printf("%f%s%f%s%.2f",a,"/",b,"=",a/b);
		int a=10; int b=3;
		System.out.println(a+"+"+b+"="+(a+b));
		System.out.println(a+"-"+b+"="+(a-b));
		System.out.println(a+"*"+b+"="+(a*b));
		System.out.println(a+"/"+b+"="+(a/b));
		System.out.printf("%d%s%d%s%.2f",a,"/",b,"=",(float)a/b);
		//정수연산정수=정수 정수연산실수,실수연산정수=실수		
	}

}
