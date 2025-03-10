package com.company.java015_ex;

import java.util.HashSet;
import java.util.Set;

public class SetEx001 {
	public static void main(String[] args) {
		Set<String> colors = new HashSet<>();
		colors.add("red");
		colors.add("green");
		colors.add("blue");
		colors.add("green");
		
		for(String x : colors) {System.out.print(x+"\t");}
		System.out.println(colors.size());
	}
}
