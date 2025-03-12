package com.company.java017;

interface interTest21 {void test();}
interface interTest22 {void test(int a);}
interface interTest23 {int test();}
interface interTest24 {int test(int a);}

public class Repeat003_Lamda {
	public static void main(String[] args) {
		interTest21 t1 = ()->System.out.println("안녕"); t1.test();
		interTest22 t2 = a->System.out.println("안녕".repeat(a)); t2.test(2);
		interTest23 t3 = ()->3; System.out.println(t3.test());
		interTest24 t4 = a->a*10; System.out.println(t4.test(3));
	}
}
