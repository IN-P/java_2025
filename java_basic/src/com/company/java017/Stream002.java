package com.company.java017;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream002 {
	public static void main(String[] args) {
		Integer[] arr = {1,4,4,2,4,5,3,4,1};
		List<Integer> list = Arrays.asList(arr);
		
		//#1 stream
		Stream<Integer> stream_arr = Arrays.stream(arr);
		Stream<Integer> stream_list = list.stream();
		
		//#2 중간연산 F2 눌러서 어떤 api 사용하는지 확인
//		stream_arr.filter((t)->{return t%2!=0;});
		stream_arr.filter(t->t%2!=0)	// 홀수 : 필터링	15311
				  .distinct()			// 중복제거		153
				  .sorted()				// 내림차순정렬	135
				  .skip(1)				// 1 건너뛰기		35
				  .forEach(t->System.out.print(t));//#3 최종연산
		System.out.println();
		System.out.println();

		stream_list.filter(t->t%2!=0)	// 홀수 : 필터링	15311
				   .distinct()			// 중복제거		153
				   .sorted()				// 내림차순정렬	135
				   .skip(1)				// 1 건너뛰기		35
				   .forEach(System.out::print);//#3 최종연산
		System.out.println();
		System.out.println();
		
		// collect
//		System.out.println(stream_arr.collect(Collectors.toList())); //일회용이라 안됨
		System.out.println(stream_arr.collect(Collectors.toList()));
		
		
	}
}
