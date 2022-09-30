package kr.or.ddit.basic.homeworkretry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Daemon extends Thread {
	
	public void print() {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			print();
		}
	}
}
