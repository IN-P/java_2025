package com.company.java010_ex;


class Area1{
	static double pi=3.141592;
	static double rect(int a,int b) {return a*b;}
	static double triangle(int a,int b) {return a*b/2;}
}

public class StaticEx001 {

	public static void main(String[] args) {
		System.out.println(""+10*10*Area1.pi);
		System.out.println(""+Area1.rect(10,5));
		System.out.println(""+Area1.triangle(10,5));
	}

}
