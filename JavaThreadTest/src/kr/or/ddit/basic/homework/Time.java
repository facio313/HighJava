package kr.or.ddit.basic.homework;

public class Time {
	Horse horse = new Horse();
	
	// 말의 이동(임의) 시간 평균 구하기
	public int avgTime() {
		int total = 0;
		for (int i = 0; i < 50; i++) {
			long startTime = System.currentTimeMillis();
			
			horse.run();
			
			long endTime = System.currentTimeMillis();
			int time = (int) (endTime - startTime);
			total += time;
		}
		int avg = total / 50;
		return avg;
	}
}
