package com.company.java015_ex;

import java.util.ArrayList;

public class ListEx001 {
	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList<>();
		colors.add("red");
		colors.add("green");
		colors.add("blue");
		System.out.println(colors);
		for (String a: colors) {
			System.out.println(a);
		}
		for (Object a: colors) { //타입지정 안하는경우 Object
			System.out.println(a);
		}
	}
}
