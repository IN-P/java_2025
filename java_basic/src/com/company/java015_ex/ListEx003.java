package com.company.java015_ex;

import java.util.ArrayList;
import java.util.Scanner;

class UserInfo{
	private String name;
	private int age;
	
	public UserInfo() { super(); }
	public UserInfo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + "]";
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
}

public class ListEx003 {
	public static void main(String[] args) {
		ArrayList<UserInfo> users = new ArrayList<>();
		users.add(new UserInfo("아이언맨",50));
		users.add(new UserInfo("헐크",40));
		users.add(new UserInfo("캡틴",120));
		
		for(int i=0;i<users.size();i++) {
			System.out.println(users.get(i).toString());
		}
		System.out.println();
		for(UserInfo u : users) {
			System.out.println(u.toString());
		}
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("원하는 유저의 이름을 입력 > ");
		String name = scanner.next();
		for(UserInfo u : users) {
			if(u.getName().equals(name)) System.out.printf("\"%s\", %d",u.getName(),u.getAge());;
		}
		scanner.close();
		
	}
}
