package com.company.java017;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda004_api {
	public static void main(String[] args) {
		//#1 consumer<T> 받는용도 - accept
		//Consumer<String> consumer = (t)->{System.out.println("Hello "+t);};
		//Consumer<String> consumer = t->System.out.println("Hello "+t);
		Consumer<String> consumer = System.out::println;
		consumer.accept("Cat");
		
		//#2 Supplier 제공용도 -get
		Supplier<String> supplier = ()->"Hello";
		System.out.println(supplier.get());
		
		//#3 Predicate 판단용도 - test
		//1. 메서드찾기
		Predicate<Integer> predicate=a->a<0;
		System.out.println(predicate.test(-1));
		System.out.println(predicate.test(1));
		
		//#4 Function 처리용도 - apply
		//Function<String,Integer> function = k->Integer.valueOf(k);
		Function<String,Integer> function = Integer::valueOf;
		System.out.println(function.apply("10")+3);
		
		//#5 Operator 연산용도 - apply
		IntBinaryOperator operator = (a,b)->a>=b?a:b;
		System.out.println(operator.applyAsInt(10, 3));
	}

}
