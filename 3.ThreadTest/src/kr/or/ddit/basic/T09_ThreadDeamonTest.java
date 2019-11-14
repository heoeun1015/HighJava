package kr.or.ddit.basic;

public class T09_ThreadDeamonTest {
	public static void main(String[] args) {
		
		AutoSaveThread autoSave = new AutoSaveThread();
		
		// 데몬 쓰레드로 설정하기 (start() 메서드 호출하기 전에 설정한다.)
		
		autoSave.setDaemon(true);	// 데몬 쓰레드 설정
									// 설정해주지 않으면 무한루프에 빠져서 계속 쓰레드가 돈다. 콘솔창에 terminated(프로그램 종료)가 뜨지 않음.
		autoSave.start();
		
		
			try {
				for(int i = 1; i <= 20; i++) {
					System.out.println("작업: " + i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("▷ 메인 쓰레드 종료");
		
	}
}


// 자동 저장하는 기능을 제공하는 쓰레드 클래스 (데몬으로 돌리냐, 쓰레드로 돌리냐의 차이)
class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("▷ 작업한 내용을 저장합니다.");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			save();		// 저장기능 호출 
		}
		
	}
}