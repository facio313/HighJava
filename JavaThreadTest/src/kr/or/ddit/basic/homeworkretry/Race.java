package kr.or.ddit.basic.homeworkretry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race extends Thread {
	
	static int currRank = 1;
	
	public static void main(String[] args) {
		//말 10마리
		List<Horse> race = new ArrayList<Horse>();
		race.add(new Horse(1));
		race.add(new Horse(2));
		race.add(new Horse(3));
		race.add(new Horse(4));
		race.add(new Horse(5));
		race.add(new Horse(6));
		race.add(new Horse(7));
		race.add(new Horse(8));
		race.add(new Horse(9));
		race.add(new Horse(10));
		
		Daemon daemon = new Daemon();
		daemon.setDaemon(true);
		daemon.start();
		
		for (Thread th : race) {
			th.start();
		}
		
		for (Thread th : race) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(race);
		
		System.out.println("경기 끝...");
		System.out.println("-----------------------");
		System.out.println("경기 결과");
		System.out.println();
		System.out.println("=======================");
		System.out.println("순위\t:\t이름");
		System.out.println("-----------------------");
		for (Horse horse : race) {
			System.out.println(horse.getRank() + "\t:\t" + horse.getNum() + "번 말");
		}
	}
}
