package kr.or.ddit.basic;

/**
 * 은행의 입출금을 스레드로 처리하는 예제
 */
public class T16SyncAccountTest {
	public static void main(String[] args) {
		SyncAccount sAcc = new SyncAccount();
		sAcc.deposit(10000);
		
		BankThread th1 = new BankThread(sAcc);
		BankThread th2 = new BankThread(sAcc);
		
		th1.start();
		th2.start(); // blocked 상태로 만들어 버리기
	}
}

// 은행의 입출금을 관리하는 클래스(공유객체)
class SyncAccount {
	private int balance; // 잔액이 저장될 변수

	synchronized public int getBalance() { // 밑에서 withdraw를 동기화처리 해놨지만 getBalance()를 호출해서 쓰기 때문에 얘도 동기화해줘야 함
		return balance;
	}
	
	// 입금 처리를 수행하는 메서드
	public void deposit(int money) {
		balance += money;
	}
	
	// 출금을 처리하는 메서드(출금 성공 : true, 출금 실패 : false 반환)
	// 동기화 영역에서 호출하는 메서드도 동기화 처리를 해주어야 한다. --> getBalance()
	 synchronized public boolean withdraw(int money) {
		 if (balance >= money) { // 잔액이 많을 경우...
			 
			 for (int i = 1; i <= 1000000000; i++) {}
			 
			 balance -= money;
			 
			 System.out.println("메서드 안에서 balance = " + getBalance()); //메서드 안에 getBalance()라는 메서드도 있음
			 
			 return true;
			 
		} else {
			
			return false;
		}
	}
	 
	 //synchonized블록으로 동기화해보기!
}

// 은행 업무를 처리하는 스레드
class BankThread extends Thread {
	private SyncAccount sAcc;
	
	public BankThread(SyncAccount sAcc) {
		this.sAcc = sAcc;
	}
	
	@Override
	public void run() {
		boolean result = sAcc.withdraw(6000); // 6000원 인출
		System.out.println(("스레드 안에서 result = " + result + ", balance = " + sAcc.getBalance()));
		super.run();
	}
}