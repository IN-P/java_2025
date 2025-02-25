package com.company.java007_ex;

public class ArrayEx006 {

	public static void main(String[] args) {
		double[] arr = new double[5];
		for (int i=0;i<arr.length;i++) {
			arr[i]=1+(i+1.0)/10;
			System.out.print(arr[i]+"\t");
		}
	}

}
