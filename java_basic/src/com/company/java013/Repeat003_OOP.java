package com.company.java013;

class Car4{
	private String color;
	Car4(){}
	
	public String getColor() { return color; }

	public void setColor(String color) { this.color = color; }

	@Override public String toString() { return "Car4 [color=" + color + "]"; }
	
}

public class Repeat003_OOP {
	public static void main(String[] args) {
		Car4 c1 = new Car4();
		c1.setColor("red");
		System.out.println(c1);
	}
}
