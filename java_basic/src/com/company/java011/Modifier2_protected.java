package com.company.java011; //1. java011폴더
import com.company.java011_ex.Cat;

class Cat2 extends Cat{//Cat2 : java011 / Cat : java011_ex
	public void show() {
		public_=10;
		protected_=20; //extends 사용가능(상속) - 상속받은 자식만
		//package_=30; //같은폴더에서만사용가능 //폴더달라서 사용불가
		//private_=40; //Cat 클래스에서만 사용 - getter/setter
		System.out.println(public_+"/"+protected_);
	}
}	//2. extends Cat의 기능 사용[상속]

public class Modifier2_protected {

	public static void main(String[] args) {
		Cat2 cat2 = new Cat2();
		cat2.show();
		
		cat2.public_=100;
		//cat2.protected_=200; //extends 키워드를 받은적이 없음
	}

}
