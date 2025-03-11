package com.company.java016_ex;

import java.util.HashMap;
import java.util.Map.Entry;

public class MapEx003_ex {
	public static void main(String[] args) {
		String[] data = { "A","D","B","D","B","D","B","C","E","C","B" };
//		int a=0,b=0,c=0,d=0,e=0;
		HashMap<String, Integer> map = new HashMap<>();
		//A,B,C,D,E value 작업
		for (int i=0;i<data.length;i++) {
//			switch(data[i]){
//				case "A": map.put(data[i],++a); break;
//				case "B": map.put(data[i],++b); break;
//				case "C": map.put(data[i],++c); break;
//				case "D": map.put(data[i],++d); break;
//				case "E": map.put(data[i],++e); break;
//			}
			if(map.containsKey(data[i])) map.put(data[i],map.get(data[i])+1);
			else map.put(data[i],1);						
		}
		//출력
		System.out.println(map.entrySet());
		for (String x : map.keySet()) {
			System.out.println(x+" : "+"#".repeat(map.get(x))+map.get(x));
		}
		//보험왕 찾기
//		int kingvalue=0;
//		for (Entry y : map.values()) {
//			if(y>kingvalue) kingvalue=y;
//		}
		String King=""; int temp=0;
		for (Entry<String,Integer> x : map.entrySet()) {
			if(x.getValue()>temp) {
				King=x.getKey();
				temp=x.getValue();
			}
		}
		//System.out.println(kingvalue); 확인용
		//보험왕 출력
		System.out.println("보험왕 > "+King);
	}
}
