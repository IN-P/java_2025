package part001_sort;

import java.util.Scanner;

public class SelfTest007 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("a,b,c 입력해주세요. > "); 
		char input = scan.next().charAt(0);
		switch (input) {
		case 'a':case 'A': System.out.println("apple"); break;
		case 'b':case 'B': System.out.println("banana"); break;
		case 'c':case 'C': System.out.println("coconut"); break;
		default: System.out.println("대소문자 관계없이 a,b,c만 입력가능합니다.");
		}
		scan.close();
	}

}
