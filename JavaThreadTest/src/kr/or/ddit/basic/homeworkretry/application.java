package kr.or.ddit.basic.homeworkretry;

import java.util.Arrays;

public class application {
	public static void main(String[] args) {
		Horse horse = new Horse("1번말");
		print(horse.getTrack());
		
		
		
	}
	// 화면 출력하는 메서드
	public static void print(String[] track) {
		for (String str : track) {
			System.out.print(str);
		}
		System.out.println();
	}
}
