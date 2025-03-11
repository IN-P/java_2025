package com.company.java016;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Collection004_map {
	public static void main(String[] args) {
		// key , value = add(X)put, get(key), size, remove, contains
		Map<String,String> map = new HashMap<>();
		map.put("one","하나");
		map.put("two","둘");
		//map.put("one","셋"); key 값이 같으면 덮어씀
		map.put("three","셋");
		System.out.println(map);
		System.out.println(map.get("one")); //가져오기 key 입력 value 출력
		System.out.println(map.size());
		System.out.println(map.remove("three")); //key 를 index 처럼 사용 
		System.out.println(map);
		System.out.println(map.containsKey("one")); //containsKey/Value 두개로 사용
		System.out.println(map.containsKey("three"));
		System.out.println(map.containsValue("둘"));
		System.out.println(map.keySet()); // .keySet() : key 만 모음
		System.out.println(map.values()); // .values() : value 만 모음
		System.out.println(map.entrySet()); // .entrySet() : key, value 전부 모음
		System.out.println(); System.out.println(); System.out.println();
		//출력 향상된 for
		for(Entry<String,String> e : map.entrySet()){
			System.out.println(e.getKey()+"/"+e.getValue());
		} System.out.println();
		// iter - ver1
		//1. key 모으기 2. 처리대상확인 hasnext 3.값 꺼내오기 next
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String temp = iter.next();
			System.out.println(temp+"/"+map.get(temp));
		} System.out.println();
		
		// iter - ver2
		//1. Entry 모으기 2. 처리대상확인 3.값 꺼내오기
		Iterator<Entry<String,String>> i = map.entrySet().iterator();
		while(i.hasNext()) {
			Entry<String,String> temp = i.next();
			System.out.println(temp.getKey()+"/"+temp.getValue());
		}
		
	}
}
