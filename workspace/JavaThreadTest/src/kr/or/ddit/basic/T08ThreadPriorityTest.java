package kr.or.ddit.basic;

public class T08ThreadPriorityTest {
	public static void main(String[] args) {
		System.out.println("최대 우선순위 : " + Thread.MAX_PRIORITY); // int값 10
		System.out.println("최소 우선순위 : " + Thread.MIN_PRIORITY); // int값 1
		System.out.println("보통 우선순위 : " + Thread.NORM_PRIORITY); // int값 5
		// priority가 지정되어 있지 않으면 default는 5임
		
		Thread[] ths = new Thread[] {
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest1(),
				new ThreadTest2()
		};
		
		// 우선순위는 start()메서드 호출 전에 설정해야 한다.
		for (int i = 0; i < ths.length; i++) {
			if (i == 5) {
				ths[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				ths[i].setPriority(Thread.MIN_PRIORITY);
			}
		} 
		
		// 우선순위 출력
		for (Thread th : ths) {
			System.out.println(th.getName() + "의 우선순위 : " + th.getPriority());
		}
		
		// 동작		
		for (Thread th : ths) {
			th.start();
		}
		
		for (Thread th : ths) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// main이 가장 늦게 끝나는데 왜 그런지 잘 모르겠숨...
		// 마지막 for문이 main보고 기다리라고 하는 건데
		// thread에서 join이 몬지..
	}
}

// 대문자를 출력하는 스레드
class ThreadTest1 extends Thread {
	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch);

			// 아무 것도 하지 않는 반목문(시간 때우기 용)
			for (long i = 1; i <= 1000000000; i++) {
			}
		}
	}
}

//소문자를 출력하는 스레드
class ThreadTest2 extends Thread {
	@Override
	public void run() {
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.println(ch);

			// 아무 것도 하지 않는 반목문(시간 때우기 용)
			for (long i = 1; i <= 1000000000; i++) {
			}
		}
	}
}