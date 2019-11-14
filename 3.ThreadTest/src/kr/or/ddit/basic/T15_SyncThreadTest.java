package kr.or.ddit.basic;

public class T15_SyncThreadTest {
	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		WorkerThread th1 = new WorkerThread("▷ 1번 쓰레드", sObj);
		WorkerThread th2 = new WorkerThread("▶ 2번 쓰레드", sObj);
		
		th1.start();
		
//		try {
//			th1.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		th2.start();
		
	}
}




// 공통으로 사용할 객체
class ShareObject {
	
	private int sum = 0;
	
	//동기화 하는 방법: 메서드 자체에 동기화 설정하기
	public void add() {
//	synchronized public void add() { // 동기화 영역이 된다. 무조건 남발하면 컴퓨터의 처리 속도가 느려지기 때문에 주의해야 함.
		
		// 동기화 하는 방법2: 동기화 블럭으로 설정하기
			// 동기화를 원하는 블럭 단위로 처리하고 싶을때 사용한다.
		synchronized (this) {	// this = ShareObject에 대한 동기화 처리를 하겠다.
			
			for(int i = 0; i < 1000000000; i++) {}	// 동기화 처리 전까지 시간 벌기용
			
			int n = sum;
			n += 10;	// 10 증가
			sum = n;
			
			System.out.println(Thread.currentThread().getName() + "합계: " + sum);
		}
		
//		for(int i = 0; i < 1000000000; i++) {}
//		
//		int n = sum;
//		n += 10;	// 10 증가
//		sum = n;
//		
//		System.out.println(Thread.currentThread().getName() + "합계: " + sum);

	}
	
//	public int getSum() {
//		return sum;
//	} 
	
}



// 작업을 수행하는 쓰레드
class WorkerThread extends Thread {
	
	ShareObject sObj;
	
	public WorkerThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			sObj.add();
			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
//			for(int j = 1; j <= 1000000000; j++) {}
			
		}
		
	}
	
}







