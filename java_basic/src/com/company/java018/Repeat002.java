package com.company.java018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;

class User001 {
	String name;
	int age,no;
	public User001() { super(); }
	public User001(String name, int age, int no) {
		super();
		this.name = name;
		this.age = age;
		this.no = no;
	}
	@Override
	public String toString() {
		return no+"\t"+name+"\t"+age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name, no);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User001 other = (User001) obj;
		return age == other.age && Objects.equals(name, other.name) && no == other.no;
	}
	
}

public class Repeat002 {
	public static void main(String[] args) {
		ArrayList<User001> list = new ArrayList<>();
		HashSet<User001> set = new HashSet<>();
		HashMap<Integer,User001> map = new HashMap<>();
		
		list.add(new User001("iron",45,1));
		list.add(new User001("hulk",38,2));
		list.add(new User001("captain",120,3));
		
		System.out.println("====================\nNO\tNAME\tAGE\n====================");
		for (int i=0,sum=0;i<list.size();i++) {
			System.out.println(list.get(i));
			sum+=list.get(i).age;
			if(i==list.size()-1) {
				double avg = (double)sum/i+1;
				System.out.printf("\n나이총합 : %d\n나이평균 : %.2f\n\n",sum,avg);
			}
		}
		
		set.add(new User001("iron",45,1));
		set.add(new User001("hulk",38,2));
		set.add(new User001("captain",120,3));
		
		System.out.println("====================\nNO\tNAME\tAGE\n====================");
		int sum=0;
		for (User001 x : set) {
			System.out.println(x);
			sum+=x.age;
		}
		System.out.printf("\n나이총합 : %d\n나이평균 : %.2f\n\n",sum,(double)sum/set.size());
		
		map.put(1,new User001("iron",45,1));
		map.put(2,new User001("hulk",38,2));
		map.put(3,new User001("captain",120,3));
		
		System.out.println("====================\nNO\tNAME\tAGE\n====================");
		Iterator<Entry<Integer,User001>> i = map.entrySet().iterator(); sum=0; 
		while(i.hasNext()) {
			 User001 temp = i.next().getValue();
			 System.out.println(temp);
			 sum+=temp.age;
		}
		System.out.printf("\n나이총합 : %d\n나이평균 : %.2f\n\n",sum,(double)sum/set.size());
		
		
		
		
	}

}
