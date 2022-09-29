package kr.or.ddit.basic;

public class T04ThreadTest {
	public static void main(String[] args) {
	/*
 		1~20억까지의 합계를 구하는 데 걸린 시간 체크하기
 		
 		전체 합계를 구하는 작업을 단독 스레드로 하는 경우와 여러 개의 스레드로 분할해서 처리하는 경우의 시간을 확인해보기
	 */
		
		// 단독으로 처리할 때...
		Thread sumTh = new SumThread(1, 2000000000L);
		
		long startTime = System.currentTimeMillis();
		
		sumTh.start();
		
		try {
			sumTh.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("단독으로 처리할 때의 처리시간 : " + (endTime - startTime));
		System.out.println("\n\n");
		
		// 여러 개의 스레드가 협력해서 처리했을 때
		SumThread[] sumThs = new SumThread[] {
			new SumThread(1L, 500000000L),	
			new SumThread(500000000L, 1000000000L),	
			new SumThread(1L, 1500000000L),
			new SumThread(1L, 200000000L)
		};
		
		startTime = System.currentTimeMillis();
		
		for(Thread th : sumThs) {
			th.start();
		}
		
		for(Thread th : sumThs) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("여러 개의 스레드가 협력해서 처리할 때의 처리시간 : " + (endTime - startTime));
		System.out.println("\n\n");
	}
}

class SumThread extends Thread {
	private long min, max;

	public long getMin() {
		return min;
	}

	public void setMin(long min) {
		this.min = min;
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
	}

	public SumThread(long min, long max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void run() {
		long sum = 0;
		for (long i = min; i <= max; i++) {
			sum += i;
		}
		System.out.println(min + " ~ " + max  + "까지의 합 : " + sum);
		
	}

}