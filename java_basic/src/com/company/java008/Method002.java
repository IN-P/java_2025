package com.company.java008;

public class Method002 {

	//#1. 함수정의 
	//public<아무나> static<바로사용가능> void<리턴값> 메서드명(파라미터) {}
	public static void myint(int num) {System.out.println(num);}
	public static void myadd(int a,int b) {System.out.println(a+b);}
	
	////////////////////////////////////////
	public static void main(String[] args) {
		myint(1);
		myint(2);
		myadd(1,2);
		myadd(10,3);
	}
	////////////////////////////////////////
	
	
	

}
