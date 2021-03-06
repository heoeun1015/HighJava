package kr.or.ddit.basic;

/**
 * 멀티 쓰레드 프로그램 방식
 * @author pc16
 *
 */
public class T02_ThreadTest {
	public static void main(String[] args) {
		
		// ※ 세 방법 다 Thread를 이용해야 한다.
		
		// 방법1: Thread 클래스를 상속한 class의 인스턴스를 생성한 후 이 인스턴스의 start()메서드를 호출한다.
		
		MyThread1 th1 = new MyThread1();
		
		
		// 방법2: Runnable 인터페이스를 구현한 class의 인스턴스를 생성한 후,
		//		 이 인스턴스를 Thread 객체의 인스턴스를 생성할 때 생성자의 매개변수로 넘겨준다.
		//		 이때 생성된 Thread 객체의 인스턴스 start() 메서드를 호출한다.
		
		MyThread2 r1 = new MyThread2();
		Thread th2 = new Thread(r1);
		
		
		// 방법3: 익명 클래스를 이용하는 방법
		// Runnable 인터페이스를 구현한 익명클래스를 Thread 인스턴스를 생성할 때 매개변수로 넘겨준다.
		
		Thread th3 = new Thread(new Runnable() {
			
			@Override
			public void run() {	// run은 필수
				for(int i = 0; i <= 200; i++) {
					System.out.print("@");
					
					try {
						Thread.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		
		// 총 4개의 쓰레드가 동작하고 있음. main도 포함.
		
		// 콜스택 3개. start() = 쓰레드 호출.
		th1.start();
//		th1.run();		// 메인 쓰레드가 실행한다. 에러는 나지 않지만 멀티쓰레드가 되지 않음. 
		th2.start();
		th3.start();
		
		System.out.println("main 메서드 작업 끝.");
		// 메인은 끝나고 쓰레드는 계속 돌기 시작한다.
		
		
		
	}
}

class MyThread1 extends Thread{
	
	@Override
	public void run() {
		
		for(int i = 0; i <= 200; i++) {
			System.out.print("*");
			
			try {
				// Thread.sleep(시간) → 주어진 시간동안 작업을 잠시 멈춘다.
				// 시간은 밀리세컨드 단위를 사용한다.
				// 즉, 1000은 1초를 의미한다.
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}


class MyThread2 implements Runnable{

	@Override
	public void run() {
		
		for(int i = 0; i <= 200; i++) {
			System.out.print("$");
			
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
}















