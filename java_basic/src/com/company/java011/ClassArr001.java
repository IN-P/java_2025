package com.company.java011;

import java.util.Arrays;

class A1{
	String name;
}

public class ClassArr001 {

	public static void main(String[] args) {
		//int arr = int[3];
		A1[] carr=new A1[3];
		System.out.println(Arrays.toString(carr));
		System.out.println("갯수 > "+carr.length);
//		carr[0].name="apple"; System.out.println(carr[0]); 오류 생성자 초기화 안했기때문에
		carr[0] = new A1();
		carr[0].name="apple"; System.out.println(carr[0].name);
		
		carr[1] = new A1();
		carr[1].name="banana"; System.out.println(carr[1].name);
		
		carr[2] = new A1();
		carr[2].name="coconut"; System.out.println(carr[2].name);
		
	}

}
