package kr.or.ddit.basic.homeworkretry;

import kr.or.ddit.basic.T11DisplayCharacterTest;

public class Horse extends Thread implements Comparable<Horse> {
	private int num = 0;
	private int rank = 1;
	String[] track = new String[50];

	public Horse() {
		
	}
	
	public Horse(int num) {
		super();
		this.num = num;
	}

	public String[] getTrack() {
		for (int i = 0; i < 50; i++) {
			track[i] = "-";
		}
		return track;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			track[i] = "-";
		}

		for (int i = 0; i < 50; i++) {
			track[i] = ">";
			try {
				track[i - 1] = "-";
			} catch (ArrayIndexOutOfBoundsException e) {
				track[i] = "-";
			}

			try {
				Thread.sleep((int) (Math.random() * 500 + 500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.print(num + "번 말\t");
			print(track);
		}

		setRank(Race.currRank++);
	}

	public static void print(String[] track) {
		for (String str : track) {
			System.out.print(str);
		}
		System.out.println();
	}

	@Override
	public int compareTo(Horse horse) {
		return new Integer(this.getRank()).compareTo(horse.getRank());
	}
}