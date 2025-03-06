package com.company.java013;


//Q1. 상속도 그리기
//Q2. 각클래스에서 사용할수있는 멤버변수/멤버메서드
class Papa extends Object{  
	int money = 10000;     
	public Papa() { super(); }
	public void sing() {  System.out.println("GOD-거짓말");  }
}// end class

class Son2 extends Papa{ 
	int money = 1500;
	public Son2() { super(); }
	@Override public void sing() {  System.out.println("빅뱅-거짓말"); }
} // end class
public class Repeat006_OOP{
	public static void main(String[] args) {
		// Q8.  부모 =  자식 관계   /  업,다운캐스팅 선택 /  타입캐스팅 필요여부
		Papa mypapa = new Son2();    
		// Q3. Papa mypapa 의미?
		// Q4. 인스턴스화한 실제 메모리 빌려온그림 
		System.out.println(mypapa.money); // Q5.  출력   
		mypapa.sing();  //Q6. 출력   
		 //Q7. mypapa.money 를 이용해서  1500 출력되게 해주세요.   
	}
} 