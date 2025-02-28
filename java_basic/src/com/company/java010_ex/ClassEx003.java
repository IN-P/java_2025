package com.company.java010_ex;

class Coffee{
	String name;
	int price,num;
	
	Coffee(){ //기본생성자
		this.name="아메리카노"; 
		this.price=2000;
		this.num=1;
	}
	
	Coffee(String name,int num,int price){ // 수동생성자
		this.name="까페라떼";
		this.price=4000;
		this.num=2;
	}
	
	void show(){
		System.out.println("=====coffee");
		System.out.println("커피명 : "+name);
		System.out.println("커피잔수 : "+num);
		System.out.println("커피가격 : "+(num*price));
	}
}

public class ClassEx003 {

	public static void main(String[] args) {
		Coffee a1 = new Coffee("카페라떼",2,4000);
		a1.show();
		Coffee a2 = new Coffee();
		a2.show();
	}

}
