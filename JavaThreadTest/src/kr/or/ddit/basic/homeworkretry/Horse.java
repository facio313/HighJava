package kr.or.ddit.basic.homeworkretry;

public class Horse implements Comparable<Horse> {
	private String name;
	private int rank = 1;
	String[] track = new String[50];

	public String[] getTrack() {
		for (int i = 0; i < 50; i++) {
			track[i] = "-";
		}
		return track;
	}


	public Horse(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return String.format("Horse [name=%s, rank=%s]", name, rank);
	}
	
	public int avgTime() {
		int total = 0;
		for (int i = 0; i < 50; i++) {
			
		long startTime = System.currentTimeMillis();
		
		
		long sum = 0;
		for (long j = 1; j <= 500000000L; j++) {
			sum += j;
		}
		
		long endTime = System.currentTimeMillis();
		
		int time = (int) (endTime - startTime);
		total += time;
		}
		
		int avg = total / 50;
		return avg;
	}
	
	public int runTime() {
		long startTime = System.currentTimeMillis();

		long sum = 0;
		for (long j = 1; j <= 500000000L; j++) {
			sum += j;
		}

		long endTime = System.currentTimeMillis();
		
		int time = (int) (endTime - startTime);
		return time;
	}
	
//	@Override
//	public void run() {
//	">" 이걸 넣어주는 것만 넣어놓고	
//	어플리케이션에서 while과 if문 쓰기
//	}

	@Override
	public int compareTo(Horse horse) {
		return Integer.valueOf(getRank()).compareTo(Integer.valueOf(horse.getRank()));
	}
}