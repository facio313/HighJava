package kr.or.ddit.basic.homework;
//package kr.or.ddit.basic.homeworkretry;
//
//public class Horse4 extends Thread implements Comparable<Horse> {
//	private String name;
//	private int rank = 1;
//	String[] track = new String[50];
//
//	public Horse4(String name) {
//		super();
//		this.name = name;
//	}
//	
//	public String[] getTrack() {
//		for (int i = 0; i < 50; i++) {
//			track[i] = "-";
//		}
//		return track;
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
//	}
//	
//	public int avgTime() {
//		int total = 0;
//		for (int i = 0; i < 50; i++) {
//			
//		long startTime = System.currentTimeMillis();
//		
//		
//		long sum = 0;
//		for (long j = 1; j <= 500000000L; j++) {
//			sum += j;
//		}
//		
//		long endTime = System.currentTimeMillis();
//		
//		int time = (int) (endTime - startTime);
//		total += time;
//		}
//		
//		int avg = total / 50;
//		return avg;
//	}
//	
//	public int runTime() {
//		long startTime = System.currentTimeMillis();
//
//		long sum = 0;
//		for (long j = 1; j <= 500000000L; j++) {
//			sum += j;
//		}
//
//		long endTime = System.currentTimeMillis();
//		
//		int time = (int) (endTime - startTime);
//		return time;
//	}
//	
////	@Override
////	public void run() {
////	">" 이걸 넣어주는 것만 넣어놓고	
////	어플리케이션에서 while과 if문 쓰기
////	}
//
//	@Override
//	public int compareTo(Horse horse) {
//		return Integer.valueOf(getRank()).compareTo(Integer.valueOf(horse.getRank()));
//	}
//}