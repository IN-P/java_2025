package part001_sort;

import java.util.Scanner;

public class SelfTest012 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i;
		while (true){
			System.out.print("숫자입력");
			i=scan.nextInt();
			if(i>=1&&i<=100) break;
		}
		scan.close();
	}

}
