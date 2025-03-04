package com.company.java011; //1. java011폴더

//class Cat2{} 같은 폴도내에 같은 클래스명이 존재하기 때문에 불가함
//package - default - 기본 - 같은폴더에서 사용가능

public class Modifier3_package {

	public static void main(String[] args) {
		Cat2 cat = new Cat2(); //import 안해도 사용가능
		
		cat.public_=10;
		//cat.protected_=20;
		//cat.package_=30;
		//cat.private_=40;
		cat.show();
	}

}
