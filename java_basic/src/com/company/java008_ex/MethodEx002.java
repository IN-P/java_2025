package com.company.java008_ex;

public class MethodEx002 {
	
	public static void main(String[] args) {
		test1(10);
		test2(1.2);
		hap(3,5);
		disp(7,'*');
	}
	
	public static void test1(int n) {System.out.println(n);}
	public static void test2(double n) {System.out.println(n);}
	public static void hap(int a, int b) {
		int sum=0;
		for (int i=a;i<=b;i++) {sum+=i;}
		System.out.println(sum);
		}
	public static void disp(int n,char s) {
		String str=""+s;
		System.out.println(str.repeat(n));
		}
	
}
