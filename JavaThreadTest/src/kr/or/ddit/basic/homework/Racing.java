//package kr.or.ddit.basic.homework;
//
//import java.util.Arrays;
//
///**
// * 게임이 시작될 경마장 
// */
//public class Racing {
//	public static void main(String[] args) {
//		Horse horse1 = new Horse(1, 1);
//		Horse horse2 = new Horse(2, 1);
//		Horse horse3 = new Horse(3, 1);
//		Horse horse4 = new Horse(4, 1);
//		Horse horse5 = new Horse(5, 1);
//		Horse horse6 = new Horse(6, 1);
//		Horse horse7 = new Horse(7, 1);
//		Horse horse8 = new Horse(8, 1);
//		Horse horse9 = new Horse(9, 1);
//		Horse horse10 = new Horse(10, 1);
//
//		Thread game = new Game();
//		game.start();
//		
//		
//	}
//}
//
///**
// * 경마 게임 설계
// * 하나의 말이 달리는 경로 설정
// */
//class Game extends Thread {
//	
//	@Override
//	public void run() {
//		String[] track = {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"};
//		for (int i = 0; i < 50; i++) {
//			track[i] = ">";
//			try {
//				track[i-1] = "-";
//			} catch (ArrayIndexOutOfBoundsException e) {
//			}
//			System.out.println("");
//			System.out.print(new Horse().getName());
//			print(track);
//		}
//	}
//	public static void print(String[] track) {
//		for(String str : track) {
//			System.out.print(str);
//		}
//		System.out.println();
//	}
//}	
//	
//
///**
// * 말 설계
// */
//class Horse implements Comparable<Horse> {
//	private String name;
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
//	public String getName() {
//		return no + "번 말";
//	}
//	
//	public int getNo() {
//		return no;
//	}
//
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
//	@Override
//	public int compareTo(Horse horse) {
//		return Integer.valueOf(getRank()).compareTo(Integer.valueOf(horse.getRank()));
//	}
//	
//}