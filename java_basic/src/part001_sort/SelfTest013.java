package part001_sort;

import java.util.Scanner;

public class SelfTest013 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("원하는 구구단을 입력 > ");	
		int num = scan.nextInt();
		System.out.println("== "+num+"단 ==");
		for(int i=1;i<10;i++) {
			System.out.println(num+"×"+i+"="+(num*i));
		}
		scan.close();
	}

}
