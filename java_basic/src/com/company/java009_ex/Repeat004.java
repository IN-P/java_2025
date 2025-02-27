package com.company.java009_ex;

public class Repeat004 {

	public static void main(String[] args) {
		char[][] arr = new char[2][3];
		char ch ='a';
		for(int y=0;y<arr.length;y++) {
			for(int x=0;x<arr[0].length;x++) {
				arr[y][x]=ch++;
				System.out.print(arr[y][x]+"\t");
			}
			System.out.println();
		}
	}

}
