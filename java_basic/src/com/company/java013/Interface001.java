package com.company.java013;
//1. 클래스는 부품객체
//2. 상태와 행위
interface Animal1{
	String COMPANY="(주) 동물농장";//static final - method area, new 관련없음
	void eat();// abstract - {}없어서 new 못함
}
class Saram implements Animal1{
	@Override public void eat() { /*COMPANY="해물탕회사";*/ System.out.println("밥 식사...."); }
}
class Pig implements Animal1{
	@Override public void eat() { System.out.println("꿀꾸리...."); }
}



public class Interface001 {
	public static void main(String[] args) {
//		Animal1 ani = new Animal1(); 인스턴스화못함, 설계목적
		System.out.println(Animal1.COMPANY);
		Animal1[] anis = {new Saram(),new Saram(),new Pig(),new Pig()};
		for(Animal1 a:anis) {a.eat();}
	}

}
