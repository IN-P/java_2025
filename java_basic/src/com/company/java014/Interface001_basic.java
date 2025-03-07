package com.company.java014;

interface Animal{
	String NAME="홍길동";
	void eat();
}

class Saram implements Animal{
	@Override public void eat() {
//		NAME = "아이유"; 변수타입이 static final(생략되어있음) 이기때문에  수정불가
		System.out.println(NAME+"이 냠냠해요.");
	}
}

public class Interface001_basic {
	public static void main(String[] args) {
//		Animal ani = new Animal(); 객체화 불가
		Animal ani = null;
		ani = new Saram(); ani.eat();
	}

}
