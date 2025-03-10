package com.company.java015_ex;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx002 {
	public static void main(String[] args) {
		ArrayList<String> numbers = new ArrayList<>();
		numbers.add("one");
		numbers.add("two");
		numbers.add("three");
		Scanner scanner = new Scanner(System.in);
		System.out.print("1,2,3 중 입력 > ");
		try{
			int index = scanner.nextInt();
			//ver1
//			if (index==1) {
//				System.out.println(numbers.get(0));
//			} else if(index==2) {
//				System.out.println(numbers.get(1));
//			} else if(index==3) {
//				System.out.println(numbers.get(2));
//			} else {
//				System.out.println("1,2,3이 아닙니다.");
//			}
			//ver2
//			for(int i=0;i<numbers.size();i++) {
//				if (i==index) System.out.println(numbers.get(index-1));
//			}
			
			
			if(index>0||index<4) System.out.println(numbers.get(index-1));
			else System.out.println("1,2,3이 아닙니다.");
		}
		catch(Exception e){
			System.out.println("1,2,3이 아닙니다.");
		}
		scanner.close();
	}
}
