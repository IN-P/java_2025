package com.company.java009_ex;

import java.util.Scanner;

class MyPrice001{
	String name;
	int price;
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("상품이름 입력 > ");
		this.name = scanner.next();
		this.price = 9000000;
		System.out.println("상품가격 출력 > "+this.price+"원");
		scanner.close();
	}
	void show() { //매개변수와 클래스 변수
		System.out.println("상품정보입니다.");
		System.out.println("상품이름 : "+name+" / "+"상품가격 : "+price+"원");
	}
}
public class ClassEx002 {

	public static void main(String[] args) {
		MyPrice001 p1 = new MyPrice001();
		p1.input();
		p1.show();
	}

}
