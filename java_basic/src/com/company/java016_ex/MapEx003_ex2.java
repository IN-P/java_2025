package com.company.java016_ex;

import java.util.HashMap;

public class MapEx003_ex2 {
	public static void main(String[] args) {
		HashMap<String , HashMap<String, String>> animalCard = new HashMap<>();
		HashMap<String, String> group = new HashMap<>();  // DOG, CAT, PIG
		String[][] data = new String[][] {
			{"DOG", "first", "NO-111"} ,  
			{"DOG", "second", "NO-222"} ,  
			{"DOG", "third", "NO-333"} ,  
			{"CAT", "red", "NO-444"} ,  
			{"CAT", "green", "NO-555"} ,  
			{"CAT", "blue", "NO-666"} ,  
			{"PIG", "sally", "NO-777"} ,  
			{"PIG", "alpha" , "NO-888"}  
		};
		//데이터 담기
		for (String[] x : data) {
			if(!animalCard.containsKey(x[0])) { //Card key 없으면 group 초기화해서 담기 
				animalCard.put(x[0], group = new HashMap<>());
				group.put(x[2],x[1]);
			}
			group.put(x[2],x[1]);
		}
		
		for (String y : animalCard.keySet()) {
			System.out.println("==============");
			System.out.println("* "+y+"["+animalCard.get(y).size()+"]");
			System.out.println("==============");
			for(String z : animalCard.get(y).keySet()) {
				System.out.println(z+"\t"+animalCard.get(y).get(z));
			}
			System.out.println();
		}
	}
}
