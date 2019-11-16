package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T06_ListSortTest {
	public static void main(String[] args) {
		
		/*
		 	정렬과 관련된 interface에는 Comparable과 comparator 가 있다.
		 	
		 	- 보통 객체 자체에 정렬 기능을 넣기 위해서는 Comparable을 구현하고,
		 	   위의 예제처럼 정렬 기준을 별도로 구현하고 싶을 때는 Comparator를 구현하여 사용하면 된다.
		 	   
	 	   	- Comparable에서는 compareTo()메서드를 구현해야 하고,		// compareTo()는 파라미터 1개
	 	   	  Comparator에서는 compare()메서드를 구현해야 한다.		// compare()는 파라미터 2개 (앞이 더 크면 양수, 뒤면 음수, 같으면 0) 
		 */
		
		List<String> list = new ArrayList<String>();
		//String을 만들면 안에 Comparable이 구현되어 있기 때문에 정렬이 가능하다.
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬 전: " + list);
		
		// 정렬은 Colloections.sort()메서드를 이용하여 정렬한다.
		// 정렬은 기본적으로 '오름차순 정렬'을 수행한다.
		
		// 정렬 방식을 변경하려면 정렬방식을 결정하는 객체를 만들어서 Collections.sort()메서드에 인수로 넘겨주면 된다.
		
		// Collection: 	인터페이스.
		// Collections: 클래스. static이라 바로 호출 가능.
		Collections.sort(list);		//오름차순으로 정렬하기
		System.out.println("정렬 후: " + list);
		
		Collections.shuffle(list);	//데이터를 섞어준다.
		System.out.println("자료섞기 후: " + list);
		
		// 정렬 방식을 결정하는 객체를 이용하여 정렬하기
		Collections.sort(list, new Desc());		//Descend: 내림차순
		System.out.println("정렬 후: " + list);
		
	}
}

	/*	정렬 방식을 결정하는 class는 Comparator라는 인터페이스를 구현해야 한다.
	 	이 Comparator 인터페이스의 compare()라는 메서드를 재정의하여 구현하면 된다. */

class Desc implements Comparator<String>{	//정렬기능이라 Comparator를 구현해줘야 한다.

		/*	compare()메서드의 반환값을 결정하는 방법
		 	→ 이 메서드가 양수를 반환하면 두 값의 순서가 바뀐다.
		 	
		 	- 오름차순 정렬일 경우
		 	→ 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환하도록 한다.
		 	
		 	- String 객체에는 정렬을 위해서 comparaTo()메서드가 구현되어 있는데,
		 	   이 메서드의 반환값은 오름차순에 맞게 반환되도록 구현되어 있다.
		 	  (Wrapper 클래스와 Date, File 클래스에도 구현되어 있다.) */
	
	
		@Override
		public int compare(String str1, String str2) {
//			return str1.compareTo(str2) * 1;		// 오름차순
//			return str1.compareTo(str2) * 0;		// 안바뀐다.
			return str1.compareTo(str2) * -1;		// 내림차순
		}
	
}


