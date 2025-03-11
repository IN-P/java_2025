package com.company.java016;
// 1. 클래스는 부품객체 - 설계도 (틀, can do this~!)
// 2. 상태 + 행위 - interface (public static final / public abstract)
interface Inter1{void method();}
class Inter1Impl implements Inter1{
	@Override public void method() { System.out.println("Hello :D"); } 
} 



public class Lambda001 {
	public static void main(String[] args) {
		// #1. interface - 구현객체 만들기
		Inter1 a1 = new Inter1Impl();
		a1.method();
		
		// #2. 익명이너클래스(test목적, 잘사용하지 않음)
		Inter1 a2 = new Inter1() {
			@Override public void method() { System.out.println("Hello :D :D"); }
		};
		a2.method();
		
		// #3. lambda 뭐받아서 처리 ()->{}; // void method();
		Inter1 a3 = ()->{System.out.println("Hello :D :D :D");};
		a3.method();
		// 실행문이 하나면 {} 생략가능
		Inter1 a4 = ()->System.out.println("Hello :D :D :D");
		a4.method();
	}
}
