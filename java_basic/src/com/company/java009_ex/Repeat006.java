package com.company.java009_ex;

public class Repeat006 {

	public static void main(String[] args) {
		hi();
		hi(1);
		System.out.println(hi("PIN"));
	}
	
	public static void hi() {System.out.println("Hi");}
	public static void hi(int num) {System.out.println("Hi "+num);}
	public static String hi(String name) {return "hi "+name;}

}
