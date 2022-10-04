package kr.or.ddit.basic;

public class T13ThreadStopTest {
	public static void main(String[] args) {
		/*
		ThreadStopEx1 th1 = new ThreadStopEx1(); // 왜 여기선 Thread 타입으로 선언 안 했나?
		th1.start();
		
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		//th1.stop(); @deprecated
		th1.setStop(true); //flag를 맞춰서 하는 게 권장됨
		*/
		
		ThreadStopEx2 th2 = new ThreadStopEx2();
		th2.start();
		
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		th2.interrupt();
		
		
	}
}

//flag 정보로 stop 시키는 것
class ThreadStopEx1 extends Thread {
	
	private boolean stop; //default : false
	
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}


	@Override
	public void run() {
		
		while(!stop) {
			System.out.println("스레드 처리 중...");
		}
		
		System.out.println("자원 정리 중...");
		System.out.println("실행 종료.");
	}
}

//interrupt() 메서드를 이용하여 스레드를 stop 시키는 것
class ThreadStopEx2 extends Thread {
	@Override
	public void run() {
		
	// 방법 1 => sleep()메서드나 join()메서드 등을 사용했을 때 interrupt()메서드를 호출하면 InterruptedException이 발생한다.
		/*
		 * try {
			while(true) {
				System.out.println("스레드 처리 중...");
				Thread.sleep(1);
			}
		} catch (InterruptedException ex) {
			
		}
		
		*/
		
	// 방법 2 => 인터럽트가 걸렸는지 검사하는 방법
		while(true) {
			System.out.println("스레드 처리 중...");
			
			// 검사 방법 1 => 스레드의 인스턴스 객체용 메서드를 이용하는 방법
			/*
			if (this.isInterrupted()) {
				System.out.println("인스턴스용 isInterrupted()");
				break;
			}
			*/
			
			// 검사 방법 2 => 스레드의 정적 메서드를 이용하는 방법
			if(Thread.interrupted()) {
				System.out.println("정적 메서드 interrupted()");
				break;
			}
		}
		System.out.println("자원 정리 중...");
		System.out.println("실행 종료.");
	}
}