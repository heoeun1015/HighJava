package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class T09_SetTest {
	public static void main(String[] args) {
		
		/* << List와 Set의 차이점 >>
		
		1. List
		- 입력한 데이터의 순서가 있다.
		- 중복되는 데이터를 저장할 수 있다.
		
		2. Set
		- 입력한 데이터의 순서가 없다.
		- 중복되는 데이터를 저장할 수 없다.*/
		
		
		Set hs1 = new HashSet<>();
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set 데이터: " + hs1);
		System.out.println();
		System.out.println("───────────────────────────────────────");
		
		
		// Set은 데이터의 순서가 없고, 중복을 허용하지 않는다.
		// 그래서 이미 있는 데이터를 add하면 false를 반환하고, 데이터는 추가되지 않는다.
		
		boolean isAdd = hs1.add("FF");
		System.out.println("중복되지 않을 때: " + isAdd);
		System.out.println("Set 데이터: " + hs1);
		System.out.println();
		
		isAdd = hs1.add("CC");
		System.out.println("중복될 때: " + isAdd);
		System.out.println("Set 데이터: " + hs1);
		System.out.println();
		System.out.println("───────────────────────────────────────");
		
		
		// Set의 데이터를 수정하려면 수정하는 명령이 따로 없기 때문에 해당 자료를 삭제한 후 새로운 데이터를 추가해주어야 한다.
		   //(순서가 없기 때문.)
		
		// 삭제하는 메서드. 수정을 할 수 없기 때문에 삭제를 하고 따로 추가를 해줘야 한다.
		// 1) clear() → Set 데이터 전체 삭제
		// 2) remove(삭제할 자료) → 해당자료 삭제
		
		// ex) 'FF'를 'EE'로 수정하기
		hs1.remove("FF");	// FF 자료 삭제
		System.out.println("삭제 후 Set 데이터: " + hs1);
		System.out.println();
		
		hs1.add("EE");		// EE 자료 추가
		System.out.println("Set 데이터: " + hs1);
		System.out.println("───────────────────────────────────────");
		System.out.println();
		
		hs1.clear();		// 전체 자료 삭제
		System.out.println("clear 후 Set: " + hs1);
		System.out.println("Set의 자료 개수: " + hs1.size());
		System.out.println();
		
		
		
		
		// Set은 데이터의 순서가 없기 때문에 List처럼 인덱스로 데이터를 하나씩 불러올 수 없다.
		// 그래서 데이터를 하나씩 얻기 위해서는 Iterator로 변환해야 한다.
		
		// Set 데이터를 Iterator로 변환하기 → Set의 iterator() 메서드를 호출하면 된다.
		Iterator it = hs1.iterator();	//Iterator: 반복자
		
		
		
		// 데이터 개수만큼 반복하기
		// hasNext()메서드 → 포인터 다음 위치에 데이터가 있으면 true, 없으면 false를 반환한다.
		
		// hasNext(): 다음에 읽을 자료가 있는 확인
		// next(): 다음에 읽어야 할 데이터의 위치를 반환
		
		while(it.hasNext()) {	// 다음 자료가 있는지 검사.
								// 다음 포인터에 자료가 있으면 출력하고, 없으면 출력하지 않는다.
								// 출력을 하면 0으로 돌아오게 되는데, 출력하면 next()로 다음 포인터로 이동하고를 반복한다.
			// next() 메서드 → 포인터를 다음 자료 위치로 이동하고, 이동한 위치의 자료를 반환한다.
			System.out.println(it.next());
		}
		System.out.println("───────────────────────────────────────");
		
		
		// 1 ~ 100 사이의 중복되지 않는 정수 5개 만들기
		HashSet<Integer> intRnd = new HashSet<Integer>();
		
			// Set을 사용해 중복되지 않은 수를 출력한다. Set이기 때문에 가능.
		while(intRnd.size() < 5) {		// Set의 데이터가 5개가 될 때까지 반복
			int num = (int)(Math.random() * 5 + 1); 	// 1 ~ 100사이의 난수
			intRnd.add(num);
		}
		
		System.out.println("만들어진 난수들: " + intRnd);
		
		
		
		
		// Collect 유형의 객체들은 서로 다른 자료 구조로 쉽게 변경해서 사용할 수 있다.
		// 다른 종류의 객체를 생성할 때 생성자에 변경할 데이터를 넣어주면 된다.
		ArrayList<Integer> intRndList = new ArrayList<Integer>(intRnd);
			// Set을 괄호 안에 넣어주면 ArrayList 객체로 변형할 수 있다. 데이터 자체가 바뀌는 것이 아님. 사용할 수 있다.
		System.out.println("List의 자료 출력");
		
		for(int i = 0; i < intRndList.size(); i++) {
			System.out.print(intRndList.get(i) + " ");
		}System.out.println();
		
		for(Integer num : intRndList) {
			System.out.print(num + " ");
		}System.out.println();
		
		for(Integer num : intRnd) {		// 원래 형태로 다시 바꿔도 출력이 된다.
			System.out.print(num + " ");
		}
			//Iterator을 구현해야만 사용할 수 있다.
		
		
	}
}















