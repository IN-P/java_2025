package com.company.java013;

class Parent{
	int i,j;
	public Parent(){super();}
	public Parent(int i, int j){
		super();
		this.i=i;
		this.j=j;
	}
}

class Child extends Parent{
	int k;
	public Child() { super(); }
	public Child(int i, int j, int k) { 
		super(i, j); 
		this.k=k; 
	}
}

public class Repeat005_OOP {
	public static void main(String[] args) {
		Child child = new Child(10,20,30);
		System.out.println(child.i);
		System.out.println(child.j);
		System.out.println(child.k);
	}

}
