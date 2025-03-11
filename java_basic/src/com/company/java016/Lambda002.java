package com.company.java016;

interface InterA2{  void hi1();}    
interface InterB2{  void hi2(String name);}  
interface InterC2{  String hi3();}   
interface InterD2{  String hi4(int num, String name);} 

public class Lambda002 {
	public static void main(String[] args) {
		System.out.println("[STEP1] 매개변수X, 리턴값X");
		//1-1. 익명객체 h1출력
		InterA2 a1 = new InterA2() {
			@Override public void hi1() { System.out.println("hi"); }
		};
		a1.hi1();
		//1-2. 람다식 ()->{}
		InterA2 a2 = ()->System.out.println("hi");
		a2.hi1();
		
		InterB2 b1 = new InterB2() {
			@Override public void hi2(String name) { System.out.println(name+" hi"); } 
		};
		b1.hi2("IU");
		
		InterB2 b2 = (name)->{ System.out.println(name+" hi");};
		b2.hi2("IU");
		//매개변수도 한개면 ()생략가능 실행문도 한개 {}생략가능
		InterB2 b3 = name-> System.out.println(name+" hi");
		b3.hi2("IU");
		
		InterC2 c1 = new InterC2() {
			@Override public String hi3() { return "hi"; } 
		};
		System.out.println(c1.hi3());
		
		InterC2 c2 = ()->{return "hi";};
		System.out.println(c2.hi3());
		//매개변수 없으면 return 생략 가능 
		InterC2 c3 = ()->"hi";
		System.out.println(c3.hi3());
		
		InterD2 d1 = new InterD2() {
			@Override public String hi4(int num, String name) { return name+" hi".repeat(num); } 
		};
		System.out.println(d1.hi4(2, "IU"));
		
		InterD2 d2 = (a,b)->{return b+" hi".repeat(a);};
		System.out.println(d2.hi4(3, "IU"));
		//매개변수가 여러개고 {}안에 return 만 존재할 경우
		InterD2 d3 = (a,b)-> b+" hi".repeat(a);
		System.out.println(d3.hi4(4, "IU"));
	}
}
