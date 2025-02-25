package com.company.java007_ex;

public class ArrayEx007 {

	public static void main(String[] args) {
		char[] arr = new char[5];
		for (int i=0;i<arr.length;i++) {
			arr[i]=(char) (65+i);
			System.out.print(arr[i]+"\t");
		}
	}

}
