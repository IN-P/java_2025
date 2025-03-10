package com.company.java015_ex;

import java.util.ArrayList;
import java.util.Scanner;

class Fruits{
	private int no;
	private String name;
	private int price;
	
	public Fruits() { super(); }
	public Fruits(int no, String name, int price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}
	@Override public String toString() {
		return "Fruits [no=" + no + ", name=" + name + ", price=" + price + "]";
	}
	
	public int getNo() { return no; }
	public void setNo(int no) { this.no = no; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
}

public class ListEx004 {
	public static void main(String[] args) {
		ArrayList<Fruits> fruits = new ArrayList<>();
		fruits.add(new Fruits(1,"apple",2000));
		fruits.add(new Fruits(2,"banana",2500));
		fruits.add(new Fruits(3,"coconut",4500));
		
		for(int i=0;i<fruits.size();i++) {
			System.out.printf("번호 : %d,\t이름 : %s,\t가격 : %d\n",fruits.get(i).getNo(),fruits.get(i).getName(),fruits.get(i).getPrice());
		}
		System.out.println();
		for(Fruits u : fruits) {
			System.out.printf("번호 : %d,\t이름 : %s,\t가격 : %d\n",u.getNo(),u.getName(),u.getPrice());
		}
		System.out.println();
		
		String[] fruitinfo = {"사과는 빨갛다","바나나는 노랗다","코코넛은 코코하다"};
		Scanner scanner = new Scanner(System.in);
		System.out.print("1,2,3 과일정보를 입력하시오. _");
		int index = scanner.nextInt();
		System.out.printf("번호 : %d,\t이름 : %s,\t가격 : %d\n",fruits.get(index-1).getNo(),fruits.get(index-1).getName(),fruits.get(index-1).getPrice());
		System.out.println(fruitinfo[index-1]);
		scanner.close();
	}
}
