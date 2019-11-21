package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Vector, HashTable등의 예전부터 존재하던 Collection 들은 내부에 동기화 처리가 되어 있다.
// 그러나 최근에 새로 구성된 Collection들은 동기화 처리가 되어 있지 않다.
// 그래서 동기화가 필요한 프로그램에서 이런 Collection들을 사용하려면 동기화 처리를 한 후에 사용해야 한다.

public class T18_SyncCollectionTest {
	
	// 동기화를 하지 않을 경우
	private static List<Integer> list1 = new ArrayList<Integer>();
	// 방 생성을 하는 타이밍에 값을 넣으려 했기 떄문에 오류가 발생한다.
	/*Exception in thread "Thread-0" Exception in thread "Thread-2"
	Exception in thread "Thread-1" Exception in thread "Thread-3" java.lang.ArrayIndexOutOfBoundsException: 1851*/
	
	
	// 동기화를 하는 경우
	// Collections의 정적 메서드 중에서 synchronized로 시작하는 메서드 이름
	private static List<Integer> list2 = Collections.synchronizedList(new ArrayList<Integer>());
	
	public static void main(String[] args) {
		// 익멸 클래스로 쓰레드 구현
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <= 10000; i++) {
//					list1.add(i);	// 동기화 처리를 하지 않은 리스트 사용
									// 안에 데이터가 몇이 들어가던 ArrayList가 대신 체크를 해준다.
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
					list2.add(i);	// 동기화 처리한 리스트 사용
				}
			}
		};
		
		Thread[] ths = new Thread[] {
				new Thread(r),
				new Thread(r),
				new Thread(r),
				new Thread(r),
				new Thread(r)
		};
		
		for(Thread th : ths) {
			th.start();
		}
		
		for(Thread th : ths) {
			try {
				th.join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
//		System.out.println("list1의 개수: " + list1.size());
		System.out.println("list2의 개수: " + list2.size());
	}
	
}
