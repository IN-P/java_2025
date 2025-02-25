package com.company.java008_ex;

public class Repeat004 {

	public static void main(String[] args) {
		int[][] arr= new int[2][3];
		int data=10;
		for (int y=0;y<arr.length;y++) {
			for(int x=0;x<arr[0].length;x++) {
				arr[y][x]=data; data+=10;
				System.out.print(arr[y][x]+"\t");
			}
			data+=10; System.out.println();
		}
	}
//<button class="btn btn-warning my-3" onclick="alret('박인')">TWO</button>	
}
