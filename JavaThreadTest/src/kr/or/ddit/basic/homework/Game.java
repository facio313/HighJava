//package kr.or.ddit.basic.homework;
//
//public class Game extends Thread {
//	Horse horse = new Horse();
//
//	@Override
//	public void run() {
//		for (int i = 0; i < 50; i++) {
//			if (horse.runTime() > horse.avgTime()) {
//				horse.track[i] = ">";
//				System.out.print(horse.getNames());
//				print(horse.track);
//			} 
//		}
//	}
//	
//	// 화면 출력하는 메서드 
//	public static void print(String[] track) {
//		for (String str : track) {
//			System.out.print(str);
//		}
//		System.out.println();
//	}
//}