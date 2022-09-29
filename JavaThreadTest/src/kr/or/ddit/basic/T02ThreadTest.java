package kr.or.ddit.basic;

/**
 * 멀티스레드 프로그램 생성 예제
 */
public class T02ThreadTest {
	public static void main(String[] args) {

		// 방법1 : Thread 클래스를 상속한 class의 인스턴스를 생성한 후 이 인스턴스의 start()메서드를 호출한다. => 나도 Thread가 된다!!라는 것
		Thread th1 = new MyThread1();
		th1.start(); // run()이랑 먼 차이? MyThread1의 쓰레드가 동작하고 있음(메인 쓰레드는 죽음)
		// start()는 쓰레드를 새로 만들고, 호출스택도 새로 만듬
		// start()를 안 하고 run()을 바로 만들면 메인쓰레드로 돌리게 됨
		
		// 방법2 : Runnable 인터페이스를 구현한 class의 인스턴스를 생성한 후 이 인스턴스를 Thread객체의 인스턴스를 생성할 대 생성자의 파라미터로 넘겨준다.
		//			이렇게 생성된 인스턴스의 start()메서드를 호출한다.
		// 자바는 다중상속이 되지 않아서(C++은 됨) (이미 다른 상속을 받는다면) 이 방법을 씀
		Runnable r = new MyThread2();
		Thread th2 = new Thread(r);
		th2.start();
		
		// 두 개의 쓰레드가 동시에 작업함 ex)*$$**$*$$*$*$**$$**$*$$**$$*$*$**$*$$**$*$$**$$**$$*$**$$*$*$*...
		
		// 방법3 : 익명클래스를 이용하는 방법 - Runnable인터페이스를 구현한 익명클래스를 Thread인스턴스를 생성할 때 매개변수로 넘겨준다.
		// 클래스는 객체를 마구 찍어내기 위해 만드는데 익명클래스는 한 번만 쓰면 돼서!
		Thread th3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <= 200; i++) {
					System.out.print("@");
					
					try {
						// Thread.sleep(시간) => 주어진 시간만큼 잠시 멈춘다.
						// 시간은 ms(1000) 단위이다. 1000ms = 1초
						Thread.sleep(100);
					} catch (InterruptedException e) { // 잠자는 동안 깨워질 수 있다
						e.printStackTrace();
					}
				}
			}
		});
		th3.start(); // 쓰레드가 4개 동작하고 있다! (th1, th2, th3, main)
		
		// 두 개의 쓰레드가 동시에 작업함 ex)*$@$@*$*@@$*$*@$*@$*@$*@@$*$@*@*$$@*@$**@$@*$*@$*$@@*$@$*$*@$@*@*$*$@*@$
		// 별도의 쓰레드를 만들지 않고(=start()를 호출하지 않고) 구동시키면 ex)*******************...$$$$$$$$$$$$$$$$$$$$...@@@@@@@@@@@@@@@@
		// main이 폴스택에 쌓이고 th1.run()이 쌓였다 끝나면 없어지고 th2.run()이 쌓였다 끝나면 없어지고 th3.run()이 쌓였다 끝나면 없어지고 main이 끝난다.
		// main 쓰레드 하나만 작업하는 것
		// 그래서 쓰레드를 별도로 생성하고 별도의 폴스택을 만들어 동작하게 하려면 start()를 호출해야 함
	}
}

class MyThread1 extends Thread {
	
	// Thread클래스라면 갖고 있는 run() - 가장 중요한 메서드
	@Override
	public void run() {
		for (int i = 1; i <= 200; i++) {
			System.out.print("*");
			
			try {
				// Thread.sleep(시간) => 주어진 시간만큼 잠시 멈춘다.
				// 시간은 ms(1000) 단위이다. 1000ms = 1초
				Thread.sleep(100);
			} catch (InterruptedException e) { // 잠자는 동안 깨워질 수 있다
				e.printStackTrace();
			}
		}
	}
}

class MyThread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 200; i++) {
			System.out.print("$");
			
			try {
				// Thread.sleep(시간) => 주어진 시간만큼 잠시 멈춘다.
				// 시간은 ms(1000) 단위이다. 1000ms = 1초
				Thread.sleep(100);
			} catch (InterruptedException e) { // 잠자는 동안 깨워질 수 있다
				e.printStackTrace();
			}
		}
	}
}