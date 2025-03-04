package part001_sort;

import java.util.Scanner;

public class SelfTest003 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("당신의 이름을 입력하세요. > "); 
		String name = scan.next();
		System.out.println("당신의 이름은 "+name+"입니다.");
		scan.close();
	}

}
