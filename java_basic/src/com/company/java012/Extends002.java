package com.company.java012;


class Color{
	private String name;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	}
class Green extends Color{
	int num; 
	void show() {
		System.out.println("::::: GREEN");
		System.out.println("= NAME : "+super.getName()); //부모꺼 표현 super
		System.out.println("= NUM  : "+this.num); //자기꺼 표현 this
	}
}

public class Extends002 {
	public static void main(String[] args) {
		Green mygreen = new Green();
		mygreen.setName("LIGHT_GREEN");
		mygreen.num=5;
		mygreen.show();
	}

}
