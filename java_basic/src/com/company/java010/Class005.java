package com.company.java010;

class Farm{
	String name; 
	int age;
	static String FarmName = "(주)동물농장";
	static int num = 10;
	
	static void num_plus() {num++;}
	void show() {
		System.out.println("\n\n:::::::::::::::::::::::");
		System.out.println("::회사명 : "+Farm.FarmName);
		System.out.println("::식구수 : "+Farm.num);
		System.out.println("::이  름 : "+this.name);
		System.out.println("::나  이 : "+this.age);
	}
	
}

public class Class005 {

	public static void main(String[] args) {
		System.out.println("Step1. 클래스변수-static");
		System.out.println("회사명 > "+Farm.FarmName);
		System.out.println("식구수 > "+Farm.num);
		
		System.out.println("\\n\\nStep2. 인스턴스변수-this-각각");
		Farm cat = new Farm(); cat.name="야옹이"; cat.age=10; cat.show();
		Farm dog = new Farm(); dog.name="멍멍이"; dog.age=3; dog.show();
		
		
	}

}
