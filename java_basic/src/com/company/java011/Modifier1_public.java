package com.company.java011;

import com.company.java011_ex.Cat;

public class Modifier1_public {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.public_=10;
//		cat.protected_=10; 안보임 The field Cat.protected_ is not visible
//		cat.package_=10;
//		cat.private_=10;
		cat.setPrivate_(100);
		System.out.println(cat.public_+"/"+cat.getPrivate_());
		//private 은 getter + setter 이용
	}

}
