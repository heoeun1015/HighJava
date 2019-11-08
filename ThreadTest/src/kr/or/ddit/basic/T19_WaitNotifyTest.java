package kr.or.ddit.basic;

	/*  wait()메서드 → 동기화 영역에서 락을 풀고 Wait-Set 영역으로 이동시킨다.
		notify() 또는 notifyAll() 메서드 → Wait-Set 영역에 있는 쓰레드를 깨워서 실행될 수 있도록 한다.
		(notify()는 하나, notifyAll()은 Wait-Set에 있는 전부를 꺠운다.)
		
		→ 	wait()와 notify(), notifyAll() 메서드는 동기화 영역에서만 실행할 수 있고,
			Object 클래스에서 제공하는 메서드이다. */


// wait()와 notify()를 이용한 두 쓰레드가 번갈아가면서 한 번씩 실행하는 예제
public class T19_WaitNotifyTest {

	public static void main(String[] args) {
		
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();

		
		// 실행을 해도 프로그램이 종료(terminate)되지 않는다. 한 명은 대기 상태로 기다리고 있음.
		try {
			thA.join();
			thB.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("───────────────────────────────────────");
		System.out.println("메인메서드 종료");
		
	}
	
}



// 공통으로 사용할 객체
class WorkObject{
	public synchronized void methodA() {
		System.out.println("▷ methodA 메서드 작업 중...");
		
		notify();		// 쓰레드 대기실. 한 명만 깨울 수 있고, 그 순서는 정해줄 수 없다. 야 일단 나와봐 의 느낌.
		
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB() {
		System.out.println("         ▶ methodB 메서드 작업 중...");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}




// WorkObject의 methodA() 메서드만 호출하는 쓰레드
class ThreadA extends Thread{
	
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			workObj.methodA();
		}
	}
	
}


//WorkObject의 methodB() 메서드만 호출하는 쓰레드
class ThreadB extends Thread{
	
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			workObj.methodB();
		}
		
	
	}
	
}














