package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

public class T07ThreadGame {
	
	public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		
		// 랜덤함수를 통해 0이면 가위, 1이면 바위, 2이면 보를 설정
		int rcp = new Random().nextInt(3);
		String comRcp = ""; // comRcp는 컴퓨터의 가위바위보
		
		switch (rcp) {
		case 0:
			comRcp = "가위";
			break;
		case 1:
			comRcp = "바위";
			break;
		case 2:
			comRcp = "보";
			break;		
		}
		
		Thread td1 = new CountDown5();
		td1.start();
		
		String str = JOptionPane.showInputDialog("가위 or 바위 or 보");
		
		System.out.println("=== 결 과 ===");
		System.out.println("컴퓨터 : " + comRcp);
		System.out.println("당 신 : " + str);
		
		if(comRcp.equals(str)) {
			System.out.println("결과 : 비겼습니다.");
		} else if (comRcp.equals("가위") && str.equals("보") ||
					comRcp.equals("바위") && str.equals("가위") ||
					comRcp.equals("보") && str.equals("바위")) {
			System.out.println("결과 : 컴퓨터가 이겼습니다.");
		} else {
			System.out.println("결과 : 당신이 이겼습니다.");
		}
	}
}


/**
* 카운트다운 처리를 하는 스레드 클래스
*/
class CountDown5 extends Thread {
	
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			
			if(T07ThreadGame.inputCheck == true) {
				return;
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);; // 프로그램 종료
	}
}