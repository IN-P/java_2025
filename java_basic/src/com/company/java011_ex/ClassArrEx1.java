package com.company.java011_ex;

public class ClassArrEx1 {

	public static void main(String[] args) {
		Apple[] apples= new Apple[3];
		for(int i=0;i<apples.length;i++) {apples[i]=new Apple();}
		
		apples[0].setName("RED");
		apples[0].setOrder("iron");
		apples[0].setNum(2);
		apples[0].setPrice(1000);
		
		apples[1].setName("GREEN");
		apples[1].setOrder("hulk");
		apples[1].setNum(1);
		apples[1].setPrice(1500);
		
		apples[2].setName("GOLD");
		apples[2].setOrder("captain");
		apples[2].setNum(3);
		apples[2].setPrice(2000);
		
		
//		for(int i=0;i<apples.length;i++) {System.out.println(apples[i]);}		
		for(Apple one : apples) {System.out.println(one);}	//향상된 for문	
	}

}
