package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

public class T07ThreadGame2 {

	public static boolean inputCheck = false;

	public static void main(String[] args) {

		Thread td1 = new Rcp();
		td1.start();

		Thread td2 = new CountDown6();
		td2.start();
	}
}

/**
 * 클래스로 가위바위보 게임 배열로 해보기!
 */
class Rcp extends Thread {

	@Override
	public void run() {
		int num = new Random().nextInt(3);
		String[] comRcp = { "가위", "바위", "보" };

		String str = JOptionPane.showInputDialog("가위 or 바위 or 보");

		System.out.println("=== 결 과 ===");
		System.out.println("컴퓨터 : " + comRcp[num]);
		System.out.println("당 신 : " + str);

		if (comRcp[num].equals(str)) {
			System.out.println("결과 : 비겼습니다.");
		} else if (comRcp[num].equals("가위") && str.equals("보") || comRcp[num].equals("바위") && str.equals("가위")
				|| comRcp[num].equals("보") && str.equals("바위")) {
			System.out.println("결과 : 컴퓨터가 이겼습니다.");
		} else {
			System.out.println("결과 : 당신이 이겼습니다.");
		}
	}
}

/**
 * 카운트다운 처리를 하는 스레드 클래스
 */
class CountDown6 extends Thread {

	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {

			if (T07ThreadGame2.inputCheck == true) {
				return;
			}

			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
		; // 프로그램 종료
	}
}