package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class P13_MapTest {
	public static void main(String[] args) {
		
		/* << Map >>
		 	→ key값과 value값을 한 쌍으로 관리하는 객체
			→ key값은 중복을 허용하지 않고 순서가 없다. (Set의 특징)
			→ value값은 중복을 허용한다.*/
		
		Map<String, String> map = new HashMap<String, String>();
		
		// 자료 추가 → put(key값, value값);
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1111-1111");
		
		System.out.println("map → " + map);
		
		
		// 자료 수정 → 데이터를 저장할 때 key값이 있으면 나중에 입력한 값이 저장된다.
		//			put(수정할 key값, 새로운 value값);
		map.put("addr", "서울");
		System.out.println("map → " + map);
		
		// 자료 삭제 → remove(삭제할 key값);
		map.remove("name");
		System.out.println("map → " + map);
		
		// 자료 읽기 → get(key값);
		System.out.println("addr = " + map.get("addr"));
		System.out.println("──────────────────────────────────────────────");
		
		
		
		// key값들을 읽어와 자료를 출력하는 방법
		// 방법1 → keySet()메서드 이용하기
		// keySet()메서드 → Map의 key값들만 읽어와서 Set형으로 반환한다.
		Set<String> keySet = map.keySet();			//key값만 가지고 있는 Set
		
		System.out.println("《 Iterator를 이용한 방법 》\n");
		
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();					//key를 가져온다. key만 있으면 value도 가져올 수 있음.
			System.out.println(key + ": " + map.get(key));
		}System.out.println("──────────────────────────────────────────────");
		
		
		
		// 방법2 → Set형의 데이터를 '향상된 for문'으로 처리하면 Iterator를 사용하지 않아도 된다.
		System.out.println("《 향상된 for문을 이용한 방법 》\n");
		for(String key : keySet) {
			System.out.println(key + ": " + map.get(key));
			
		}System.out.println("──────────────────────────────────────────────");
		
		
		
		// 방법3 → value값만 읽어와 출력하기 → values()메서드 이용하기
		System.out.println("《 values()메서드를 이용한 방법 》\n");		//key값 말고 value값만 보고 싶을 때
		for(String value : map.values()) {
			System.out.println(value);
		}System.out.println("──────────────────────────────────────────────");
		
		
		// 방법4 → Map에는 Entry라는 내부 class가 만들어져 있다.
		//		   이 Entry는 key와 value라는 멤버변수로 구성되어 있다.
		//		  Map에서 이 Entry클래스들을 Set형식으로 저장하여 관리한다.
		
		// Entry객체 전체를 가져오기(가져온 Entry들은 Set형식으로 되어 있다.)
		// → entrySet()메서드를 이용하여 가져온다.
		
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
//		Set<Entry<String, String>> mapSet = map.entrySet();
		
		//가져온 Entry객체들을 순서대로 처리하기 위해서 Iterator객체로 변환
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
//		Iterator<Entry<String, String>> entryIt = mapSet.iterator();
		
		while(entryIt.hasNext()) {		//Entry 있는지 없는지 한 번 확인해준다.
			Map.Entry<String, String> entry = entryIt.next();		//Entry 객체를 넣어준다.
//			Entry<String, String> entry = entryIt.next();
			
			System.out.println("key값: " + entry.getKey());
			System.out.println("value값: " + entry.getValue());
			System.out.println("----------------------------------------------");
		}
		
		
		

		
		
		
	}
}
