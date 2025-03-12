package com.company.java017;

import java.util.Arrays;
import java.util.List;

public class Stream001 {
	public static void main(String[] args) {
		//데이터종류에 상관없이(스트림) 같은방식으로 처리(람다)
		Integer[] arr = {1,2,3,4,5};
		List<Integer> list = Arrays.asList(arr);
		//asList?,forEach?
		Arrays.stream(arr).forEach((t)->{System.out.println(t);});
		Arrays.stream(arr).forEach(t->System.out.println(t));
		Arrays.stream(arr).forEach(System.out::println);
		//<? super Integer> Integer 포함 상위
		//Consumer<? super Integer> action;
		System.out.println();
		list.stream().forEach(System.out::println);
	}

}
