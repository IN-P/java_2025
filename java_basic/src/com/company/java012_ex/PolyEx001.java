package com.company.java012_ex;
/*
	Object
	 ↑
	Papa {money=10000 / sing="GOD-거짓말"}
	 ↑
	Son {money=1500 / sing="빅뱅-거짓말"}

*/


class Papa extends Object{
	int money = 10000;
	public Papa() {super();}
	public void sing() {System.out.println("GOD-거짓말");}
}

class Son extends Papa{
	int money = 1500;
	public Son(){super();}
	@Override public void sing() {System.out.println("빅뱅-거짓말");}
}

public class PolyEx001 {
	public static void main(String[] args) {
		Papa mypapa = new Son();
	  //Papa mypapa ← {money=10000 / sing="GOD-거짓말"}
	  //new Son(); ← {money=1500 / sing="빅뱅-거짓말"} - {money=10000 / --- (오버라이딩)}
	  //mypapa : new Son의 주소 ← {money=1500 / sing="빅뱅-거짓말"} - {money=10000 / --- (오버라이딩)}
	  //									 [여기서부터                여기까지보장]	
		System.out.println(mypapa.money);
		System.out.println(((Son)mypapa).money); //타입캐스팅
		
	}

}
