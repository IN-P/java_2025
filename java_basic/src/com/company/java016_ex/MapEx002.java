package com.company.java016_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class UserInfo{
	String name;
	int age;
	
	public UserInfo() { super(); }
	public UserInfo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}

public class MapEx002 {
	public static void main(String[] args) {
		Map<Integer,UserInfo> map = new HashMap<>();
		map.put(1, new UserInfo("아이언맨",50));
		map.put(2, new UserInfo("헐크",40));
		map.put(3, new UserInfo("캡틴",120));
		map.put(1, new UserInfo("아이언맨-MK2",50));
		
		Iterator<Integer> num = map.keySet().iterator(); // map.keySet() 키들을 모음
		while(num.hasNext()) {
			Integer key = num.next(); // key 에 모아놓은 키를 담고
			UserInfo temp = map.get(key); 
			// value는 수동생성자이므로 해당하는 키의 수동생성자를 클래스에 잠시 담고
			System.out.println("번호 : "+key);
			System.out.println("이름 : "+temp.name); //출력
			System.out.println("나이 : "+temp.age);
			System.out.println();
		}
	}

}
