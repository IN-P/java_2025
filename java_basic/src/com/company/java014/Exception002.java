package com.company.java014;


public class Exception002 {
	public static void main(String[] args) {
		//1. try catch finally
		//try{에러날것같아} catch(에러내용){} finally{맨마지막 무조건처리, 생략가능}
		try{System.out.println(10/0);}
		//catch(ArithmeticException e) {System.out.println("관리자 호출!");}
		catch(Exception e) {System.out.println("관리자 호출!");}
		finally {System.out.println("무조건실행");}
		//2.throws 메서드
	}
}

/*
                                  #1 ArithmeticException 복사
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at com.company.java014.Exception002.main(Exception002.java:7) #2 줄수

 */