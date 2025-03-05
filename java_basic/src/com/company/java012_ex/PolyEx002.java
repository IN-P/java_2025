package com.company.java012_ex;

class Parent7 extends Object {
	int x = 100;
	public Parent7() { super(); }
	void method() { System.out.println("Parent Method"); }
}

class Child7 extends Parent7 {
	int x = 200;
	public Child7() { super(); }
	@Override void method() { System.out.println("Child Method"); }
	@Override
	public String toString() {
		return "Child7 [x=" + x + "]";
	}
	
}

public class PolyEx002 {
	public static void main(String[] args) {
		Parent7 p = new Child7();
		// Q3. Parent7 p 보장하는 범위
		// {x=100/method="Parent Method"}
		// Q4. 인스턴스화 했을때 사용가능한 범위 : new Child7()
		// 주소 ← {x=200/method="Child Method"} - {x=100/ --- }
		// p=주소 ← {x=200/[[method="Child Method"} - {x=100]]/ --- } /[[보장]]
		Child7 c = new Child7();
		System.out.println("p.x = " + p.x); // Q5. 출력되는 내용 : 100
		p.method(); // Q6. 출력되는 내용 : Child Method
		System.out.println("c.x = " + c.x); // Q7. 출력되는 내용 : 200
		c.method(); // Q8. 출력되는 내용 : Child Method
		// c.x 를 이용해 부모의 x꺼내오기 100
		System.out.println(((Parent7)c).x); //클래스 타입캐스팅은 상속관계에서만 적용된다
		Child7 c1 = (Child7)p; 
		//원래는 오류가 난다 왜냐하면 p를 자식까지 확장해도 자식안에있는 멤버변수가 초기화가 되지 않았기 때문에
		//하지만 현재는 22줄에서 부모가 자식을 받는 과정에서 멤버변수가 한번 초기화해서 들어갔기떄문에
		//오류 없이 작동
		System.out.println(c1);
	}

}
