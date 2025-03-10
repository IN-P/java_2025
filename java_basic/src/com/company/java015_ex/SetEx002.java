package com.company.java015_ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class UserInfo2{
	private int no;
	private String name;
	private int age;
	
	public UserInfo2() { super(); }
	public UserInfo2(int no, String name, int age) {
		super(); this.no = no; this.name = name; this.age = age;
	}
	
	public int getNo() { return no; }
	public void setNo(int no) { this.no = no; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	
	//클래스 배열은 Set 사용해도 중복가능하기 때문에 중복처리 하는 방법
	//ctrl+shift+s generate hashCode() and equal() 
	@Override public int hashCode() { return Objects.hash(age, name, no); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo2 other = (UserInfo2) obj;
		return age == other.age && Objects.equals(name, other.name) && no == other.no;
	}
	
	
	
}

public class SetEx002 {
	public static void main(String[] args) {
		Set<UserInfo2> users = new HashSet<>();
		users.add(new UserInfo2(1,"아이언맨",50));
		users.add(new UserInfo2(2,"헐크",40));
		users.add(new UserInfo2(3,"캡틴",120));
		users.add(new UserInfo2(3,"캡틴",120));

		System.out.println(users.size());
		
		for(UserInfo2 x : users) {
			System.out.printf("번호 : %d\t이름 : %s\t나이 : %s\n"
				,x.getNo(),x.getName(),x.getAge());
		}
		System.out.println();
		Iterator<UserInfo2> iter = users.iterator(); //모으기
		while(iter.hasNext()) {//iter.next() 
			UserInfo2 temp = iter.next(); //꺼내기
			System.out.printf("번호 : %d\t이름 : %s\t나이 : %s\n"
					,temp.getNo(),temp.getName(),temp.getAge());
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요. _");
		String name = sc.next();
		for (UserInfo2 y : users) {
			if (y.getName().equals(name)) {
				System.out.printf("번호 : %d\t이름 : %s\t나이 : %s\n"
						,y.getNo(),y.getName(),y.getAge());
			}
		}
		sc.close();
	}
}
