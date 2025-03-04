package com.company.java011;

import com.company.java011_ex.Milk;

public class ModifierEx1 {
	public static void main(String[] args) {
		Milk m1 = new Milk(); // 다른폴더 import
		System.out.println(m1);
		m1.setMprice(2000);
		System.out.println(m1);
	}
}
