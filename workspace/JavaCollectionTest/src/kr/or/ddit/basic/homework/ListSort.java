package kr.or.ddit.basic.homework;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSort {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		

		list.add(new Student("201406197", "최경수", 100, 100, 100));
		list.add(new Student("202006173", "비욘세", 99, 73, 95));
		list.add(new Student("201706155", "장사라", 48, 100, 84));
		list.add(new Student("202206166", "라우브", 100, 68, 77));
		list.add(new Student("199906188", "브루노", 87, 69, 100));


		// 순위 구하기
		int[] totalList = new int[list.size()]; // 점수를 담을 배열 만들기
		int[] rank = new int[list.size()]; // 초기 순위값 배열 만들기

		for (int i = 0; i < list.size(); i++) {
			totalList[i] = list.get(i).getTotal();
		}
		// totalList = { 300, 267, 256, 245, 232 }

		for (int i = 0; i < totalList.length; i++) {
			rank[i] = 1; // for 돌 때마다 1등으로 초기화
			for (int j = 0; j < totalList.length; j++) {
				if (totalList[i] < totalList[j]) {
					rank[i] = rank[i] + 1;
					list.get(i).setRank(rank[i]);//중요중요!!!!
				}
			}
		}
		// 순위 구한 것 0일 때 1로 바꿔주기 --> 왜 안 돼?
//		for (int i = 0; i < totalList.length; i++) {
//			if(rank[i] == 0) {
//				rank[i] = 1;
//			} else {
//				rank[i] = rank[i];
//			}
//		}
		
		System.out.println();
		
		// 정렬 전
		System.out.println("===== 정렬 전 =====");
		for (Student student : list)
			System.out.println(student);

		// 학번의 오름차순으로 정렬
		System.out.println("===== 학번순 =====");
		Collections.sort(list);

		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println();

		// 총점의 내림차순으로 정렬
		System.out.println("===== 총점순 =====");
		Collections.sort(list, new Desc());
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println();
	}
}

class Desc implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		if (student1.getTotal() > student2.getTotal()) {
			return -1;
		} else if (student1.getTotal() == student2.getTotal() && (student1.getId().compareTo(student2.getId())) != 0) {
			return 0;
		} else {
			return 1;
		}
	}
}

// 중복 --> 인수형꺼 참고하기