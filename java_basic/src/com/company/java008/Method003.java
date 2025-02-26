package com.company.java008;

public class Method003 {

	public static String sign() {return "sally";}
	public static int num() {return (int)(Math.random()*45);} //Math.random 0~0.9999
	public static double pi() {return 3.141592;}
	public static String hello(String s) {return "HI "+s;}
	///////////////////////////////////////////
	public static void main(String[] args) {
	//public static 리턴값 메서드명(파라미터) {}
		System.out.println("키미노 나마에와 ? "+sign());
		
		int yournum = num();
		System.out.println("랜덤숫자 : "+yournum);
		
		System.out.println("원주율 : "+pi());
		
		System.out.println(hello("sally"));

		System.out.println(hello("alpha"));
		
	}
	///////////////////////////////////////////
}
