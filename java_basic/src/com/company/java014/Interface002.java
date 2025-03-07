package com.company.java014;

class Class1{}
class Class2{}

interface Inter21{void method1();}
interface Inter22{void method2();}
interface Inter23 extends Inter21,Inter22{}

class Using1 extends Class1 implements Inter21,Inter22{
	@Override public void method2() {  }
	@Override public void method1() {  }
}

public class Interface002 {
	public static void main(String[] args) {
		Using1 my = new Using1();
		if (my instanceof Object) {System.out.println("1. Object");}
		if (my instanceof Class1) {System.out.println("2. Class1");}
		if (my instanceof Inter21) {System.out.println("3. Inter21");}
		if (my instanceof Inter22) {System.out.println("4. Inter22");}
		if (my instanceof Using1) {System.out.println("5. Using1");}
	}

}
