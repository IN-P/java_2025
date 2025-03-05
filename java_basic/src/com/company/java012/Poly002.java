package com.company.java012;

class TestA2 extends Object{
	int a=10;
	@Override public String toString() { return "TestA2 [a=" + a + "]"; }
}
class TestB2 extends TestA2{
	int b=20;
	@Override public String toString() { return "TestB2 [b=" + b + "]"; }
}

public class Poly002 {

	public static void main(String[] args) {
		TestA2 ta = new TestB2(); //부모 = 자식 / 업캐스팅
		System.out.println(ta);
	    System.out.println(ta.a);
	    System.out.println(((TestB2)ta).b); //형변환
	}

}
