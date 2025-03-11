package com.company.java016_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx001 {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("피구왕","통키");
		map.put("제빵왕","김탁구");
		map.put("요리왕","비룡");
		System.out.println("======================");
		System.out.println("KING\tNAME");
		System.out.println("======================");
		for(Entry<String,String> x : map.entrySet()) {
			System.out.println(x.getKey()+"\t"+x.getValue());
			System.out.println("-------------");
		}
		System.out.println();
		
		System.out.println("KING의 정보를 제공중입니다.");
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 >");
		String name = sc.next();
		if (map.containsKey(name)) System.out.println("□"+name+" : "+map.get(name));
		else System.out.println("존재하지 않은 KING입니다.");
	}

}
