package com.company.java015_ex;

import java.util.HashSet;
import java.util.Set;

public class SetEx003 {
	public static void main(String[] args) {
		Set<Integer> lotto = new HashSet<>();
//		for(Integer random : lotto) {random=num++;} 배열에 자료가 없으면 향상된 for 사용불가
		while (true) {
			lotto.add((int)(Math.random()*45+1)); //0<=Math.random()<1 난수
			if (lotto.size()==6) break;
		}
		System.out.println(lotto);
	}
}
