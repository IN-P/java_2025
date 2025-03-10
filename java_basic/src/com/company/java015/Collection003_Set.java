package com.company.java015;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//1. 콜렉션프레임워크 - [배열]의 단점을 개선한 [객체]만 저장가능 (동적배열)
//2. List, Set, Map
//   List - index 가 존재, 중복허용, add/get(index)/size/remove/contains
//   Set - index 가 존재X, 중복X, add/향상된 for, Iterator/size/remove/contains  

public class Collection003_Set {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("one");
		list.add("two");
		list.add(new String("three")); // 객체
		System.out.println(list.size()+"/"+list);
		
		Set<String> set = new HashSet<>(); // 주머니 : index x, 중복허용 x
		set.add("one");
		set.add("one");
		set.add("two");
		set.add(new String("three")); // 객체
		System.out.println(set.size()+"/"+set);
		
		//Set<Int> set2 = new HashSet<>(); //int 숫자자료형
		Set<Integer> set2 = new HashSet<>(); // [객체]만 저장
		//int > Integer float> Float > double > Double,,,, Wrapper Class
		set2.add(1); // Integer e = 1;
		set2.add(new Integer(2)); // Integer e = new Integer(2);
		set2.add(3); // Integer e = 3;
		
		int a=1 ; 	 //값   기초값 (primitive type)
		Integer e=1; //객체 boxed(wrapper)
		System.out.println(a+"/"+e);
		System.out.println((byte)a+"/"+e.byteValue());
		// 1) 부품객체(클래스) = 기초값 boxed
		// 2) 클래스가 만들어 놓은 기능들 사용가능 - Wrapper
		// 3) Integer.parseInt, Double.parseDouble, String.valueOf
		for(Integer x : set2) { System.out.println(x); }
		System.out.println("1.add 2.size "+set2.size());
		System.out.println("3.remove - "+set2.remove(2));
		System.out.println("4.contains - "+set2.contains(1));
		System.out.println("4.contains - "+set2.contains(2));
		System.out.println(set2);
		
		//꺼내오는 방법들 향상된 for, iterator
		//향상된 for
		for(Integer x : set2) { System.out.println(x); }
		//iterator
		set2.iterator();
		Iterator <Integer> iter = set2.iterator(); // 줄을서시오 ! iter[1,3]
		while(iter.hasNext()) {//2. 처리대상확인 
			System.out.println(iter.next());//3. 꺼내오기
		}
		
	}
}
