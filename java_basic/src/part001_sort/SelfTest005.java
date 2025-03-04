package part001_sort;

import java.util.Scanner;

public class SelfTest005 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("당신의 나이를 입력해주세요. > "); 
		int age = scan.nextInt();
		if (age<19) System.out.println("당신은 미성년자입니다."); 
		else System.out.println("당신은 성인입니다."); 
		scan.close();
	}

}
