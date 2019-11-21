package kr.or.ddit.basic;

// << 은행의 입출금을 쓰레드로 처리하는 예제 >>
// (synchronized를 이용한 동기화 처리)
public class T16_SyncAccountTest {
	public static void main(String[] args) {
		
		SyncAccount sAcc = new SyncAccount();
		sAcc.setBalance(10000);		// 입금 처리
		
		BankThread th1 = new BankThread(sAcc);
		BankThread th2 = new BankThread(sAcc);
		
		th1.start();
		th2.start();
		
	}
}




// 은행의 입출금을 관리하는 클래스 정의
class SyncAccount {

	private int balance;	// 잔액이 저장될 변수

	public synchronized int getBalance() {
		return balance;
	}

	public synchronized void setBalance(int balence) {
		this.balance = balence;
	}

	// 입금 처리를 수행하는 메서드
	public synchronized void deposit(int money) {
		balance += money;
	}

	// 출금을 처리하는 메서드(출금 성공: true, 출금 실패: false 반환)
	// 동기화 영역에서 호출하는 메서드도 동기화 처리를 해주어야 한다.
//	public boolean withdraw(int money) {
	synchronized public boolean withdraw(int money) {
	// 처음 둘 다 들어왔기 때문에 동시 처리해서 - 금액이 생긴다. 이렇게 안 하려면 동기화를 해주어야 함.
		if(balance >= money) {	// 잔액이 많을 경우
			for(int i = 0; i <= 1000000000; i++) {}	//시간 때우기

			balance -= money;
			System.out.println("▷ 메서드 안에서 balance = " + getBalance());

			return true;
		}else {
			return false;
		}
	}

}



// 은행 업무를 처리하는 쓰레드
class BankThread extends Thread {
	private SyncAccount sAcc;

	public BankThread(SyncAccount sAcc) {
		this.sAcc = sAcc;
	}

	@Override
	public void run() {
		boolean result = sAcc.withdraw(6000);	// 6000원 인출
		System.out.println("▷ 쓰레드 안에서 result = " + result + ", balance = " + sAcc.getBalance());
	}

}








