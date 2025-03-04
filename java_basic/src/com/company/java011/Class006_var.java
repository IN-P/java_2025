package com.company.java011;

class A{
	//멤버변수
	int a;//1. 기본값 //인스턴스변수 - heap 영역 
	{a=100;}
	static String company="2. 명시적 초기화"; //2. 명시적 초기화
	//클래스변수 - method영역
	static {company="3. 초기화 블록";} //3. 초기화 블록
	//멤버함수
	void method() {int a = 3000; System.out.println(a);}//지역변수 - stack 영역 - 초기화 고려해야함
	void show() {System.out.println(this.a);}
	
	A(){}
	A(int a){this.a=a;}
	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
	
	
}

public class Class006_var {

	public static void main(String[] args) {
		System.out.println(A.company);
		
		A a1 = new A(3); System.out.println(a1);
		A a2 = new A(7); System.out.println(a2);
		a2.method();
	}

}
