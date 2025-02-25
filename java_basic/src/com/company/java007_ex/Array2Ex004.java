package com.company.java007_ex;

public class Array2Ex004 {

	public static void main(String[] args) {
		char[][] arr = new char[2][3];
		for(int y=0,a=65;y<arr.length;y++) {
			for(int x=0;x<arr[0].length;x++) {
				arr[y][x]=(char)(a+x+y);				
				System.out.print(arr[y][x]+"\t");
			}
			System.out.println();
		}
	}

}
