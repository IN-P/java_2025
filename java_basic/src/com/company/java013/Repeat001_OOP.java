package com.company.java013;

class A11{
	int a;
	
	public A11() {super();}
	public A11(int a) {super(); this.a=a;}
	
	void show() {this.a=11; System.out.println(this.a);}
	
//	static void classMethod() {this.a=12;}
	
//	int show2() {int a; return a;}
}

public class Repeat001_OOP {
	public static void main(String[] args) {
		A11 a1 = new A11();
	}

}
