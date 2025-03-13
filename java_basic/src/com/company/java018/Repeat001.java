package com.company.java018;

class Milk {
	String name;
	int price;
	public Milk() {
		super();
		this.name = "white";
		this.price = 1300;
	}
	public Milk(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override public String toString() { return name+" / "+price; }
}

class MilkPrint {
	void show (Milk[] milks) {
		for(Milk m : milks) {System.out.println("* "+m);}
	}
}

public class Repeat001 {
	public static void main(String[] args) {
		Milk []milks = new Milk[3];   
		milks[0] = new Milk("white",1000);
		milks[1] = new Milk("choco",1200);
		milks[2] = new Milk("banana",1500);
		
		MilkPrint  print = new MilkPrint();   
		print.show(milks);
		
	}

}
/*
Q1. JVM 영역

	---------------------------------------------------------------------
	[JAVA파일 ]    A.java    (1)
	      |  [JAVA 컴파일러(javac.exe) ] javac A.java      (2)
	[CLASS파일]   A.class  (3)
	---------------------------------------------------------------------
	(4) [ Class Loader]    (5)[Execution Engine]  (6) [Garbage Collector]
		↕	↕		         ↕
	    ==========================================================================
	     (7) [ Runtime Data Area]
	     [  Method (8) | Heap(9)      | Stack (10) | PC register(11)| Native Method Stack(12)] 
	    ==========================================================================
	---------------------------------------------------------------------	   
	Q1) JVM의 영역을 구분하시오.  [ Class Loader , Execution Engine , Garbage Collector , Runtime Data Area]
	Q2) [Class Loader]  JVM이 운영체제로부터 할당받은 메모리영역인 Runtime Data Area로 적재하는 역할 
	Q3) [Execution Engine]  Class Loader에 의해 메모리에 적재된 클래스(바이트 코드)들을 기계어로 변경해 명령어 단위로 실행하는 역할
	Q4) [Garbage Collector]   Heap 메모리 영역에 생성(적재)된 객체들 중에 참조되지 않는 객체들을 탐색 후 제거하는 역할 
  	Q5) [Runtime Data Area]   JVM의 메모리 영역으로 자바 애플리케이션을 실행할 때 사용되는 데이터들을 적재하는 영역 

	Q6) Runtime Data Area을 구분하시오.
		[ method , heap , stack ]
	Q7) Runtime Data Area 영역중 클래스데이터가    저장되는 영역  [methood]  ###
	Q8) Runtime Data Area 영역중 인스턴스데이터가 저장되는 영역  [heap]  ### 
	Q9) Runtime Data Area 영역중 지역변수데이터가 저장되는 영역  [stack]  ### 
	
	

Q2.  인스턴스변수, 클래스변수를 구분하시오.
class Test{
	static int cv = 1;  
	int iv = 1;          
	static {cv=2;}
	{iv=2;}
	Test(){  iv=3; }
}
public class EX015 {
	public static void main(String []args) {
		System.out.println(" 다음 중 인스턴스변수의 초기화 순서를 적으시오.  ");   ####
		Test t1 = new Test();  System.out.println(t1.iv);
	   
	} // end main
} // end class

 
runtime area [  method  | heap | stack | pc register | navtive method stack]
ㅁ 클래스변수 :   static int cv
	기본값 	| 명시적 초기화  = | 클래스 초기화블럭  { }
	[  0 	           1	                           2                ]
ㅁ 인스턴스 변수 : int iv 
	기본값	| 명시적 초기화  =  | 인스턴스 초기화 블록 | 생성자
	[  0  	           1		           2		     3  ] 
*/


