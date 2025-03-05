package com.company.java012;

class TestA4 extends Object{
	int a=10;
	@Override public String toString() { return "TestA4 [a=" + a + "]"; }
}
class TestB4 extends TestA4{
	int b=20;
	@Override public String toString() { return "TestB4 [b=" + b + "]"; }
}

public class Poly004 {
	public static void main(String[] args) {
	    TestA4 ta = new TestA4();
	    TestB4 tb = new TestB4();
	    ta=new TestB4();//에러해결방법
	    //자식이 부모를 담으려면 부모가 자식을 한번 담아서 초기화를 시켜야지만 에러가 나지 않는다.
	    tb=(TestB4)ta; //다운캐스팅 / 타입캐스팅 필요
	    //ta의 메모리는 형변환으로 만족하지만 int b는 생성자 호출해서 초기화 한적이 없어서 에러남
	    System.out.println(tb);
	}

}
