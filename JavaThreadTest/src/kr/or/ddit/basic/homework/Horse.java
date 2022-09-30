//package kr.or.ddit.basic.homework;
//
//public class Horse extends Thread implements Comparable<Horse> {
//	private String names;
//	private int no;
//	private int rank = 1;
//	private Integer rankk = Integer.valueOf(rank);
//	String[] track = { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-",
//			"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-",
//			"-", "-", "-", "-", "-", "-", "-", "-", "-", "-" };
//	private long time;
//
//
//	public Horse(int no) {
//		this.no = no;
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
//	// 말 순위 비교
//	@Override
//	public int compareTo(Horse horse) {
//		return Integer.valueOf(getRank()).compareTo(Integer.valueOf(horse.getRank()));
//	}
//
//	// 말이 한 칸 움직이는데 드는 과정
//	public void one() {
//		long sum = 0;
//		for (long i = 1; i <= 500000000L; i++) {
//			sum += i;
//		}
//	}
//
//	// 표준 말 한 마리가 한 칸 움직이는 시간의 평균
//	public int avgTime() {
//		int total = 0;
//		for (int i = 0; i < 50; i++) {
//			long startTime = System.currentTimeMillis();
//
//			one();
//
//			long endTime = System.currentTimeMillis();
//			int time = (int) (endTime - startTime);
//			total += time;
//		}
//		int avg = total / 50;
//		return avg;
//	}
//
//	// 한 마리의 말이 한 칸 움직이는 시간
//	public int runTime() {
//		long startTime = System.currentTimeMillis();
//
//		one();
//
//		long endTime = System.currentTimeMillis();
//		int time = (int) (endTime - startTime);
//		return time;
//	}
//
//	// Thread 메서드 
//	@Override
//	public void run() {
//		for (int i = 0; i < 50; i++) {
//			if (runTime() > avgTime()) {
//				track[i] = ">";
//				System.out.print(getNames());
//				print(track);
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
