package com.company.java012;

class TestA3 extends Object{
	int a=10;
	@Override public String toString() { return "TestA3 [a=" + a + "]"; }
}
class TestB3 extends TestA3{
	int b=20;
	@Override public String toString() { return "TestB3 [b=" + b + "]"; }
}

public class Poly003 {

	public static void main(String[] args) {
		TestB3 tb = (TestB3) new TestA3(); // 자식 = 부모 / 다운캐스팅 / 타입캐스팅(형변환)필요!
	    
	}

}
