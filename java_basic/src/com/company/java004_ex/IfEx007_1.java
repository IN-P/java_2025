package com.company.java004_ex;

import java.util.Scanner;

public class IfEx007_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("1. 정수 하나를 입력해주세요. > ");
		int num1 = scan.nextInt();
		System.out.print("2. 정수 하나를 입력해주세요. > ");
		int num2 = scan.nextInt();
		System.out.print("3. 연산자 하나를 입력해주세요.(+,-,/,*) > ");
		char operator = scan.next().charAt(0);
		
		if(operator=='+') {System.out.println(num1+"+"+num2+"="+(num1+num2));}
		else if(operator=='-') {System.out.println(num1+"-"+num2+"="+(num1-num2));}
		else if(operator=='*') {System.out.println(num1+"*"+num2+"="+(num1*num2));}
		else if(operator=='/') {System.out.println(num1+"/"+num2+"="+String.format("%.2f",(float)num1/num2));}

		scan.close();
	}

}
