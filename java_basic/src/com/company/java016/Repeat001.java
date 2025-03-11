package com.company.java016;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class UserInfo{
	private String name;
	private int age;
	
	public UserInfo() { super(); }
	public UserInfo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
}

public class Repeat001 {
	public static void main(String[] args) {
		ArrayList<UserInfo> users = new ArrayList<>();
		users.add(new UserInfo("아이언맨",50));
		users.add(new UserInfo("헐크",40));
		users.add(new UserInfo("캡틴",120));
		for(int i=0;i<users.size();i++) {
			System.out.println("이름 : "+users.get(i).getName());
			System.out.println("나이 : "+users.get(i).getAge());
		}
		System.out.println();
		
		Set<UserInfo> users2 = new HashSet<>();
		users2.add(new UserInfo("아이언맨",50));
		users2.add(new UserInfo("헐크",40));
		users2.add(new UserInfo("캡틴",120));
		for(UserInfo x : users2) {
			System.out.println("이름 : "+x.getName());
			System.out.println("나이 : "+x.getAge());
		}
		System.out.println();
		
		//1.sets 모으기 2.처리대상확인 hasNext 3.꺼내오기 next
		Iterator<UserInfo> i = users2.iterator();
		while(i.hasNext()) {
			UserInfo temp = i.next();
			System.out.println("이름 : "+temp.getName());
			System.out.println("나이 : "+temp.getAge());
		}
		
	}
}
//Q1.   다음 빈칸을 채우시오
//1. 콜렉션프레임워크
//- [배열]의 단점을 개선한 클래스 [객체]만 저장가능 ( 동적배열 )
//- 저장공간의 크기를 [동적]으로 관리함.
//
//2. 핵심 인터페이스 [List,Set,Map]
//- 인터페이스를 통해서 틀이 잡혀 있는 방법으로 
//  다양한 컬렉션 클래스를 이용함.
//
//  List : ##5.   기차      인덱스여부 [ O ] ,  중복허용여부 [ O ] ,  
//	[ add get size remove contains ] 
//  Set  : ##6.   주머니   인덱스여부  [ X ] ,  중복허용여부  [ X ]  ,   
//	[ add 향상된for/iterator size remove contains ] 
//  Map  : ##7.   사전      [ key,value ] - 쌍(Entry),        
//	[ put get(key) size remove contains  ] 
