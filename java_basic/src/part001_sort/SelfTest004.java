package part001_sort;

import java.util.Scanner;

public class SelfTest004 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("[1]국어점수를 입력해주세요. > "); 
		int kor = scan.nextInt();
		System.out.print("[2]영어점수를 입력해주세요. > "); 
		int eng = scan.nextInt();
		if (kor<40) System.out.println("국어과락"); 
		if (eng<40) System.out.println("영어과락"); 
		scan.close();
	}

}
