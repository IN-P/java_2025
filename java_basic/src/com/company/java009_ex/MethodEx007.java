package com.company.java009_ex;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx007{

	public static void who_are_you(String[][] users,Scanner scan) {
		System.out.print("아이디를 입력해주세요. > ");
		String tempId = scan.next();
		int count=0;
		for (int i=0;i<users.length;i++) {
			if(tempId.equals(users[i][0])) {System.out.println(users[i][2]);}
			count++;
		}
		if (count==users.length) {System.out.println("유저를 확인해주세요");}
	}
	
	public static void who_pass_change(String[][] users,Scanner scan) {
		while(true) {
			System.out.print("아이디를 입력해주세요. > ");
			String tempId = scan.next();
			System.out.print("비밀번호를 입력해주세요. > ");
			String tempPwd = scan.next();
			int count=0;
			for (int i=0;i<users.length;i++) {
				if(tempId.equals(users[i][0])&&tempPwd.equals(users[i][1])) {
					System.out.print("변경하실 비밀번호를 입력해주세요. > ");
					users[i][1]=scan.next();
					System.out.println("정보확인 : "+Arrays.toString(users[i]));
					return;
				}
				count++;
			}
			if (count==users.length) {System.out.println("유저를 확인해주세요");}
		}
	}
		
	public static void main(String[] args) {
		//변수
		Scanner scan=new Scanner(System.in);
		String[][] users= { //{아이디,비밀번호,나라}
				{"aaa","111","한국"},
				{"bbb","222","호주"},
				{"ccc","333","중국"}
		};
		//입력
		who_are_you(users,scan); // 아이디 입력받아 나라조회 
		
		who_pass_change(users,scan); //아이디,비밀번호일치하면 비밀번호 변경
	}
	 
}