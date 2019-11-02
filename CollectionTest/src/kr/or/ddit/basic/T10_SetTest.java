package kr.or.ddit.basic;
//TreeSet 예제

import java.util.SortedSet;
import java.util.TreeSet;

public class T10_SetTest {
	public static void main(String[] args) {
		
		// HashSet은 데이터에 순서가 없으나(등록되는 순서를 알지 못함),
		// TreeSet은 자동 정렬 기능이 들어가 있다.
		
		TreeSet<String> ts = new TreeSet<>();
		
		// 영어 대문자를 문자열로 변환하여 TreeSet에 저장
		for(char ch = 'Z'; ch >= 'A'; ch--) {		// 정렬이 되는지 보려고 확인하기 위해 --로 써줌.
			String temp = String.valueOf(ch);		// String 타입의 객체로 바꾼다.
			ts.add(temp);
		}
		
		System.out.println("TreeSet 자료: " + ts);	// --로 했지만 오름차순으로 정렬이 되어 있다.
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		
		
		// TreeSet에 저장된 자료 중 특정한 자료보다 작은 자료를 찾아서 SortedSet으로 변환하는 메서드가 있다.
		// → headSet(기준값)메서드 (기본적으로 '기준값'은 포함시키지 않는다.)
		// → headSet(기준값, 논리값) (논리값이 true이면 '기준값'을 포함)
		SortedSet<String> ss1 = ts.headSet("K");		// headSet이면 좌측, tailSet이면 우측
		System.out.println("K 이전 자료: " + ss1);								// 기준값 미포함
//		System.out.println("K 이전 자료: " + ts.headSet("K"));			// ss1이랑 같은 거
		System.out.println("K 이전 자료(기준값 포함): " + ts.headSet("K", true));	// 기준값 포함
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		
		
		
		// '기준값'보다 큰 자료를 찾아 SortedSet으로 반환하는 메서드
		// tailSet(기준값) → 기본적으로 '기준값'을 포함시킨다.
		// tailSet(기준값, 논리값) → 논리값이 false이면 '기준값'을 포함하지 않음
		SortedSet<String> ss2 = ts.tailSet("K");				// ss2이랑 같은 거
		System.out.println("K 이후 자료: " + ss2);		//기준값 포함
//		System.out.println("K 이후 자료: " + ts.tailSet("K"));	
		System.out.println("K 이후 자료(기준값 미포함): " + ts.tailSet("K",false));		//기준값 미포함
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		
		
		// subSet(기준값1, 기준값2) → 기준값1 ~ 기준값2 사이의 값을 가져온다.
		//						  ('기준값1' 포함, '기준값2' 미포함)
		// subSet(기준값1, 논리값1, 기준값2, 논리값2) → 각 기준값을 포함할지에 대한 여부를 설정함.
		//						  (논리값이 true이면 포함, false이면 미포함)
		
			// 포함하고 싶은 것만 true로 적어준다.
		System.out.println("K(포함)부터 N(미포함)까지: " + ts.subSet("K", "N"));
		System.out.println("K(포함)부터 N(포함)까지: " + ts.subSet("K", true, "N", true));
		System.out.println("K(미포함)부터 N(미포함)까지: " + ts.subSet("K", false, "N", false));
		System.out.println("K(미포함)부터 N(포함)까지: " + ts.subSet("K", false, "N", true));
		
		
		
		
		
	}
}












