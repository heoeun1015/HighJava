package kr.or.ddit.basic;

// 쓰레드의 상태를 출력하는 예제
public class T10_ThreadStateTest {

	/*	<< 쓰레드의 상태 >>
	 	
	 	NEW				: 쓰레드가 생성되고 아직 start()가 호출되지 않은 상태
	 	RUNNABLE		: 실행 중 또는 실행 가능한 상태
	 	BLOCKED			: 동기화 블럭에 의해서 일시 정지된 상태
	 	 			  	  (lock이 풀릴 때까지 기다리는 상태)
	  	WAITING			: 쓰레드의 작업이 종료되지는 않았지만 실행 가능하지 않은 (unrunnable) 일시 정지 상태
	  	TIMED_WAITING	  TERMINATED은 일시정지 시간이 지정된 경우임.
	 	TERMINATE		: 쓰레드의 작업이 종료됭 상태	 */
	
	public static void main(String[] args) {
		StatePrintThread spt = new StatePrintThread(new TargetThread());
		
		spt.start();
	
	}
	
}


// 쓰레드의 상태를 출력하는 클래스(이 클래스도 쓰레드로 작성)
class StatePrintThread extends Thread{
	private Thread targetThread;		// 상태를 출력할 쓰레드가 저장될 변수
	
	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}
	
	@Override
	public void run() {
		while(true) {
			// Thread 상태 구하기 (getState()메서드 이용)
			Thread.State state = targetThread.getState();		// state = enum 객체
			System.out.println("- 타겟쓰레드의 상태값: " + state);
			
			if(state == Thread.State.NEW) {		// 쓰레드가 또 다른 쓰레드를 start() 시켜준다.
												// targetThread 자체 별 다른 쓰레드는 없음. 시간만 멈춰준다.
				targetThread.start();
			}
			
			if(state == Thread.State.TERMINATED) {
				break;							// 쓰레드 종료
			}
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
}


// 타겟용 쓰레드
class TargetThread extends Thread {
	@Override
	public void run() {
		for(long i = 1; i <= 1000000000L; i++) {}	// 시간 지연용
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(long i = 1; i <= 1000000000L; i++) {}	// 시간 지연용
		
	}
}










