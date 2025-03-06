package com.company.java013;

class MemberCall001{
	int instanceValue=10;
	static int classValue=20;
	
	int instanceValue2 = classValue;
//	static classValue2 = instanceValue;
	
	static void staticMethod1() {
		System.out.println(classValue);
//		System.out.println(instanceValue);
	}
	
	void instanceMethod1() {
		System.out.println(classValue);
		System.out.println(instanceValue);
	}
	
	static void staticMethod2() {
		System.out.println(classValue);
//		instanceMethod1();
	}
	
	void instanceMethod2() {
		staticMethod1();
	}
	
}

public class Repeat002_OOP {
	public static void main(String[] args) {
		
	}
}
