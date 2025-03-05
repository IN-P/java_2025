package com.company.java012;

class Grand extends Object{
	public void one() {System.out.println("grand:one");}
	public void two() {System.out.println("grand:two");}
}

class Father extends Grand{
	public void three() {System.out.println("father:three");}
}

class Uncle extends Grand{
	public void four() {System.out.println("uncle:four");}
	@Override
	public void one() {System.out.println("uncle:one");}
	@Override
	public void two() {System.out.println("uncle:two");}
}

class Aunt extends Object{
	String name="MiMi";
	@Override
	public String toString() { return name+"옆집이모클래스"; }
}

public class Extends004 {
	public static void main(String[] args) {
		Father father = new Father(); father.three(); father.two(); father.one();
		Uncle uncle = new Uncle(); uncle.four(); uncle.two(); uncle.one();
		Aunt aunt = new Aunt();
		System.out.println(aunt.toString());
		System.out.println(aunt);
	}
}
