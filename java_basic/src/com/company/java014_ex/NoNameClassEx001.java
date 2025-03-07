package com.company.java014_ex;

interface Clac{public double exec(double num1,double num2);}

public class NoNameClassEx001 {
	public static void main(String[] args) {
		Clac calc = new Clac(){
			@Override public double exec(double num1, double num2) { return num1+num2; }
		};
		System.out.println(calc.exec(10,3));
	}

}
