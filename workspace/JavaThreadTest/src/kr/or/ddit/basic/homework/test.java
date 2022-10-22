package kr.or.ddit.basic.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
	public static void main(String[] args) {
		List<String> track = new ArrayList<String>();

		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < i; j++) {
				track.set(j, "-");
			}
			track.add(">");
			for (String str : track) {
				System.out.print(str);
			}
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
