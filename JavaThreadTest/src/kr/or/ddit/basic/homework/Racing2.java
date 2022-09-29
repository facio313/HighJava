//package kr.or.ddit.basic.homework;
//
//import java.util.Arrays;
//
///**
// * 게임이 시작될 경마장
// */
//public class Racing2 {
//	public static void main(String[] args) {
//		Thread h1 = new Horse(1, 1);
//		h1.start();
//		Thread h2 = new Horse(2, 1);
//		h2.start();
//		Thread h3 = new Horse(3, 1);
//		h3.start();
//		Thread h4 = new Horse(4, 1);
//		h4.start();
//		Thread h5 = new Horse(5, 1);
//		h5.start();
//		Thread h6 = new Horse(6, 1);
//		h6.start();
//		Thread h7 = new Horse(7, 1);
//		h7.start();
//		Thread h8 = new Horse(8, 1);
//		h8.start();
//		Thread h9 = new Horse(9, 1);
//		h9.start();
//		Thread h10 = new Horse(10, 1);
//		h10.start();
//	}
//}
//
///**
// * 말과 게임 합치기
// */
//class Horse extends Thread implements Comparable<Horse> {
//	private String names;
//	private int no;
//	private int rank;
//	private Integer rankk = Integer.valueOf(rank);
//
//	public Horse() {
//
//	}
//
//	public Horse(int no, int rank) {
//		super();
//		this.no = no;
//		this.rank = rank;
//	}
//
//	public String getNames() {
//		return getNo() + "번 말";
//	}
//
//	public int getNo() {
//		return no;
//	}
//
//	public void setNo(int no) {
//		this.no = no;
//	}
//
//	public int getRank() {
//		return rank;
//	}
//
//	public void setRank(int rank) {
//		this.rank = rank;
//	}
//
//	// n번 말의 순위
//
//	@Override
//	public int compareTo(Horse horse) {
//		return Integer.valueOf(getRank()).compareTo(Integer.valueOf(horse.getRank()));
//	}
//
//	// n번 말이 경주하는 게임
//
//	@Override
//	public void run() {
//
//		// 50개 구간의 트랙 만들기
//		String[] track = new String[50];
//
//		// 각 구간마다 흙 깔기
//		for (int i = 0; i < track.length; i++) {
//			track[i] = "-";
//		}
//
//		// 말의 위치를 각 구간에 표시하기
//		long startTime;
//		long endTime;
//		long oneTrackTotalTime;
//		for (int i = 0; i < track.length; i++) {
//			System.out.printf("■■■■■■■■■■■■■■■■■%d번째 게임■■■■■■■■■■■■■■■■■\n", i + 1);
//			for(int j = 0; j < 10; j++) {
//				startTime = System.currentTimeMillis();
//				track[i] = ">";
//				endTime = System.currentTimeMillis();
//				oneTrackTotalTime = endTime - startTime;
//
//			}
//		}
//		for (int i = 0; i < track.length; i++) {
//			track[i] = ">";
//			try {
//				track[i - 1] = "-";
//			} catch (ArrayIndexOutOfBoundsException e) {
//			}
//			System.out.println("");
//			System.out.printf("■■■■■■■■■■■■■■■■■%d번째 게임■■■■■■■■■■■■■■■■■\n", i + 1);
//			System.out.print(new Horse(no, rank).getNames());
//			print(track);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	// 화면 출력하는 것
//	public static void print(String[] track) {
//		for (String str : track) {
//			System.out.print(str);
//		}
//		System.out.println();
//	}
//
//	// 등수 구하기
////	public ranking() {
////		int[] totalList = new int[list.size()]; // 점수를 담을 배열 만들기
////		int[] rank = new int[list.size()]; // 초기 순위값 배열 만들기
////
////		for (int i = 0; i < list.size(); i++) {
////			totalList[i] = list.get(i).getTotal();
////		}
////		// totalList = { 300, 267, 256, 245, 232 }
////
////		for (int i = 0; i < totalList.length; i++) {
////		rank[i] = 1; // for 돌 때마다 1등으로 초기화
////			for (int j = 0; j < totalList.length; j++) {
////				if (totalList[i] < totalList[j]) {
////					rank[i] = rank[i] + 1;
////					return list.get(i).setRank(rank[i]);//중요중요!!!!
////				}
////			}
////		}
////	}
//}
