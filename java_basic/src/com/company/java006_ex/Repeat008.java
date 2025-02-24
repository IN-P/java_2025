package com.company.java006_ex;

public class Repeat008 {

	public static void main(String[] args) {
		int sum1=0,sum2=0,sum3=0;
		
		System.out.print("1~10까지 3의 배수의 합 : ");
		for(int i=1;i<=10;i++) {
			if (i%3==0) {
				sum1+=i;
				System.out.print(i+(i==9?"":"+"));
			}
		}
		System.out.print("="+sum1); System.out.println();
		
		System.out.print("1~10까지 3의 배수의 합 : ");
		int x=1;
		while (x<=10) {
			if (x%3==0) {
				sum2+=x; 
				System.out.print(x+(x==9?"":"+"));
				}
			x++;
			}
		System.out.print("="+sum2); System.out.println();
		
		System.out.print("1~10까지 3의 배수의 합 : ");
		int y=1;
		do {
			if (y%3==0) {
				sum3+=y; 
				System.out.print(y+(y==9?"":"+"));

			}
			y++;
		}
		while (y<=10);
		System.out.print("="+sum3); System.out.println();
	}
}

/*

1~10까지 3의 배수의 합 : 3+6+9= 18

 */
 