package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T04LambdaTest {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("홍길동1");
		list.add("홍길동2");
		list.add("홍길동3");
		list.add("홍길동4");
		list.add("홍길동5");
		
//		for (String str : list) {
//			System.out.println(str);
//		}
		
		// forEach()메서드 - Consumer<> 다시 보기
		list.forEach(name->System.out.println(name)); // 함수 안에 함수 ~ 함수형 프로그래밍
	}
}
