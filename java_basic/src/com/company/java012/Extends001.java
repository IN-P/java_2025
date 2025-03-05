package com.company.java012;

//1. 클래스는 부품객체
//2. 상태(멤버변수)와 행위(멤버함수)
//3. 상속 - 코드의 재사용 (수정 및 추가)

class A1 extends Object {
	int a;	public A1() { super(); } //public A1() { super(); } 기본적으론 생략되어있음
} //ctrl+shift+f 자동정렬

class B1 extends A1 {
	int b;  public B1() { super(); }
}

class C1 extends B1 {
	int c;  public C1() { super(); }

	public void show() { System.out.println(a + "/" + b + "/" + c); }
}

public class Extends001 {

	public static void main(String[] args) {
		C1 c1 = new C1();
		c1.a = 1;
		c1.b = 2;
		c1.c = 3;
		c1.show();
	}

}
