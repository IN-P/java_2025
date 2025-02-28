package com.company.java010;

class Product{
	String name;
	int price;
	
	// alt + shift + s (밑에서+3)
	// alt + shift + s (밑에서+2)
	
	public Product(String name, int price) { //오버로딩
		super();
		this.name = name;
		this.price = price;
	}


	public Product() { //기본생성자 (초기화)
		System.out.println("원하는 값으로 초기화-수동시 컴파일러 자동생성 취소");
		//문자열은 null,int 0으로 초기화
	}
	
	@Override //자식클래스(Product)에 맞게 수정 - 값 출력
	public String toString() { 
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
}

public class Class004 {

	public static void main(String[] args) {
		Product p1 = new Product();
		System.out.println(p1);
	}

}
