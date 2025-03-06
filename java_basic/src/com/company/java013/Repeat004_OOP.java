package com.company.java013;

class A{
	private String name;
	public A() { super(); }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	@Override public String toString() { return "A [name=" + name + "]"; }
}

public class Repeat004_OOP {
	public static void main(String[] args) {
		A[] arr = new A[3];
		arr[0] = new A();
		arr[1] = new A();
		arr[2] = new A();
		for(A i : arr) {System.out.println(i);} //(배열의 자료형 매개변수 : 배열이름)
	}

}
