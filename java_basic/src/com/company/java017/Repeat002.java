package com.company.java017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Milk{
	private int no;
	private String name;
	private int price;
	
	public Milk() { super(); }
	public Milk(int no, String name, int price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}
	
	public int getNo() { return no; }
	public void setNo(int no) { this.no = no; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
}

public class Repeat002 {
	public static void main(String[] args) {
		//ver_array
		ArrayList<Milk> m1 = new ArrayList<>();
		m1.add(new Milk(1,"white",1000));
		m1.add(new Milk(2,"choco",1200));
		m1.add(new Milk(3,"banana",1300));
		Iterator<Milk> i1 = m1.iterator();
		System.out.println("======================");
		System.out.println("NO\tNAME\tPRICE");
		System.out.println("======================");
		while(i1.hasNext()) {
			Milk temp = i1.next();
			System.out.println(temp.getNo()+"\t"+temp.getName()+"\t"+temp.getPrice());
		}
		System.out.println();
		//ver_set
		HashSet<Milk> m2 = new HashSet<>(); 
		m2.add(new Milk(1,"white",1000));
		m2.add(new Milk(2,"choco",1200));
		m2.add(new Milk(3,"banana",1300));
		Iterator<Milk> i2 = m2.iterator();
		System.out.println("======================");
		System.out.println("NO\tNAME\tPRICE");
		System.out.println("======================");
		while(i2.hasNext()) {
			Milk temp = i2.next();
			System.out.println(temp.getNo()+"\t"+temp.getName()+"\t"+temp.getPrice());
		}
		System.out.println();
		//ver_map
		HashMap<Integer,Milk> m3 = new HashMap<>();
		m3.put(1,new Milk(1,"white",1000));
		m3.put(2,new Milk(2,"choco",1200));
		m3.put(3,new Milk(3,"banana",1300));
		Iterator<Integer> i3 = m3.keySet().iterator();
		System.out.println("======================");
		System.out.println("NO\tNAME\tPRICE");
		System.out.println("======================");
		while(i3.hasNext()) {
			int key =i3.next();
			Milk temp = m3.get(key);
			System.out.println(temp.getNo()+"\t"+temp.getName()+"\t"+temp.getPrice());
		}
		
	}

}
