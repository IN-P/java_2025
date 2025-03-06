package com.company.java013;

abstract class Animal{ //일반클래스 + 설계
	String name; int age;
	 abstract void eat(); //추상메서드가 있으면 반드시 추상클래스로 만들어줘야함.
	 abstract void sleep();//추상메서드 {} 구현부가 없음 - 공통의속성, 구체적인 내용이 없음.
	 abstract void poo();//추상화, 일반화, 설계 : 공통적인 속성,행동
}

class Cat extends Animal{
	@Override void eat() { System.out.println(super.name+"고양이 냠냠!"); }
	@Override void sleep() { System.out.println(super.name+"고양이 코!"); }
	@Override void poo() { System.out.println(super.name+"고양이 시원!"); }
}

class Dog extends Animal{
	@Override void eat() { System.out.println(super.name+"멍멍이 냠냠!"); }
	@Override void sleep() { System.out.println(super.name+"멍멍이 코!"); }
	@Override void poo() { System.out.println(super.name+"멍멍이 시원!"); }
}

public class Abstract001 {
	public static void main(String[] args) {
//		Animal ani = new Animal(); //추상클래스는 객체생성못함 - new 메모리 빌리고, 객체생성/Animal() 초기화 / {} 구현부없음 <-에러
		Animal ani=null;
		ani = new Cat(); // 부모 = 자식 , 업캐스팅,타입캐스팅 필요없음
		ani.name="나비"; ani.eat();
		
		ani = new Dog();
		ani.name="댕댕"; ani.eat();
		
		Animal[] arr = {new Cat(),new Cat(),new Dog(),new Dog()};
		int cnt=0;
		for(Animal a : arr) {a.name="ani"+ ++cnt; a.eat();}
		
		
	}

}
