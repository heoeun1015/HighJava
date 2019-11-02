package kr.or.ddit.basic;

import java.util.Vector;

public class T01_VectorTest {
	public static void main(String[] args) {
		// Vector → List 계열 클래스
		
		Vector v1 = new Vector();
		
		System.out.println("처음 크기: " + v1.size());
		
		// Vector는 add()메서드를 이용하여 데이터를 추가할 수 있다.
		v1.add("aaa");
		v1.add(111);					//그냥 숫자.프라이머리 타입?이다.
		v1.add(new Integer(123));		//객체로 만들어서 넣었다. Vector는 객체를 담을 수 있기 때문에 컴파일러가 숫자로 바꿔준다.(오토박싱)
		v1.add('a');					//문자를 넣으면 객체화 시켜서 들어간다. new Character('a') 랑 같다.
		v1.add(true);
		v1.add(3.14);
				//객체지향 프로그래밍을 만들어야 하기 때문에 기본 타입도 객체화를 시켜줘야 한다.
				//이런걸 래퍼 클래스라고 부른다.(감싸기 때문)
		
		System.out.println("현재 크기: " + v1.size());
		
		
		
		//Vector는 addElement()메서드를 이용하여 추가할 수도 있는데, 이 메서드는 기본적으로 add()메서드와 같은 기능을 수행한다.
			//컬렉션을 상속받은 List의 프레임 워크를 구현해야 하기 때믄에 add를 쓴다. addElement를 써도 동일하다.(원래 가지고 있던 게 addElement)
		v1.addElement("ccc");
		
		System.out.println("v1 → " + v1.toString());
		
		
		
		// add(index, 데이터) → 벡터의 index 번째에 '데이터'를 끼워넣는다.(안 정하면 순차대로 만들어진다.)
		//					→ index는 0부터 시작함.
		v1.add(1, "kkk");		//2번 인덱스에 "kkk"를 넣겠다.
		System.out.println("v1 → " + v1.toString());
		
		
		
		// set(index, 데이터) → 벡터의 index번째의 값을 주어진 '데이터'로 덮어쓴다(수정된 것처럼 보임). (반환값: 원래의 데이터)
		String temp = (String) v1.set(0, "zzz");
		System.out.println("set 명령 후 v1 → " + v1);
		System.out.println("원래의 데이터: " + temp);
		
		
		
		// remove(index) → 벡터의 index 번째 자료를 삭제한다.
		//				→ 자료가 삭제되면 index번째 다음 번째 이후의 데이터들이 앞으로 자동으로 당겨져서 채워진다. (반환값: 삭제된 데이터)
		
		// remove(삭제할 데이터) → '삭제할 데이터'를 찾아 삭제한다.
		//		→ 만약 '삭제할 데이터'가 여러개이면 앞에서부터 삭제한다.
		//		→ 삭제할 데이터가 '정수형'이거나 'char형'일 경우에는 삭제할 데이터를 객체로 변환해서 사용해야 한다.
				//삭제할 때도 객체화 시켜서 삭제한다.
		v1.remove(0);
		System.out.println("삭제 후: " + v1);
		System.out.println();
		
		temp = (String)v1.remove(0);
		System.out.println("삭제된 자료: " + temp);
		System.out.println("삭제 후: " + v1);
		System.out.println();
		
		v1.add(123);
		v1.remove(true);
		System.out.println("삭제 후(true): " + v1);
		System.out.println();
		
		v1.remove(new Integer(123));
		System.out.println("삭제 후(123): " + v1);
		System.out.println();
		
		v1.remove(new Character('a'));
		System.out.println("삭제 후(a): " + v1);
		System.out.println();
		
		v1.remove(3.14);
		System.out.println("삭제 후(3.14): " + v1);
		System.out.println();
		
		// get(index) = index번째 자료를 반환한다.
		int data = (int) v1.get(0);
		System.out.println("0번째 자료: " + data);
		System.out.println("0번째 자료: " + v1.get(0));	//toString을 사용자가 안 해도 컴파일러가 자동으로 해준다.
		System.out.println("--------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		/*
		제너릭 타입(generic type)
		→ Collection 객체를 선언할 때 <>안에 그 Collection이 저장할 데이터 타입을 정해주는 것을 말한다.
		→ 이런 식으로 선언하게 되면 그 데이터 타입 이외의 데이터를 지정할 수 없다.
		  (제너릭 타입으로 선언할 수 있는 데이터 타입은 클래스여야 한다.) 	//아래 있는 타입들까지 들어갈 수 있다. 다형성.
		  (ex) int → Integer, boolean → Boolean, char → Charactor 등)

		→ 제너릭 타입으로 선언하게 되면 데이터를 꺼내올 때 별도의 형변환이 필요없다.
		 */
		
		Vector<String> v2 = new Vector<String>();	//String만 저장 가능
		Vector<Integer> v3 = new Vector<Integer>();	//Integer만 저장 가능
		// Vector<Integer> v3 = new Vector<>(); 이렇게 써도 컴파일러가 알아서 수정해준다.
		
		v2.add("안녕하세요.");
//		v2.add(123); // 오류: 다른 종류의 데이터를 추가할 수 없다.
		
		
		String temp2 = v2.get(0);
		System.out.println("temp2 → " + temp2);
		
		// ==============================================================
		
		v2.clear();	//벡터의 모든 데이터를 삭제한다.
		System.out.println("v2의 sizs(clear) = " + v2.size());
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		Vector<String> v4 = new Vector<String>();
		
		v4.add("BBB");
		v4.add("EEE");
		
		System.out.println("삭제되기 전 v2 → " + v2);
		//removeAll(Collection 객체) → 벡터의 데이터 중에서 'Collection 객체'가 가지고 있는 데이터를 모두 삭제한다.
		v2.remove(v4);
		//v2가 가지고 있는 v4의 내용을 삭제한다.
		//같은 내용이 여러개 있으면 전부 삭제한다.
		System.out.println("삭제된 후 v2 → " + v2);
		System.out.println("--------------------------");
		
		v2.clear();
		
		//데이터 다시 저장하는 부분
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		// 벡터의 데이터들을 순서대로 모두 가져와서 사용하고 싶으면 반복문을 사용하면 된다(주로 for문을 사용함).
		
		for(int i = 0; i < v2.size(); i++){
			System.out.println(i + "번째 자료: " + v2.get(i));
		}
		System.out.println("--------------------------");
		
		/*	<< 향상된 for문 >>
		 	형식)
		 	
		 	for(자료형명 변수명: 배열변수나 Collection계열 변수){
		 		처리할 내용들;
		 		…
		 		}
		 	→ 주어진 '배열변수나 Collection계열 변수'의 데이터 개수만큼 반복함.
		 	→ 반복할 때마다 '배열변수나 Collection계열 변수'의 데이터를 하나씩 꺼내와 '변수명'에 저장한 후 '처리할 내용들'을 처리한다.
		 	  (대신 인덱스 번호를 가져올 순 없음. 자료를 가져오기만 하는 거라면 사용이 권장된다.)
		 */
		
		
		for(String s : v2) {
			System.out.println(s);
		}
		System.out.println("--------------------------");
		
		//만약 제너릭을 사용하지 않은 Collection을 향상된 for문으로 처리할 경우에는 Object형으로 처리한다.
		
		for(Object obj : v1) {
			System.out.println(obj );
		}
		
		
		
		// ==============================================================
		
		System.out.println();
		System.out.println();
		
		System.out.println("===== 벡터 사이즈 및 용량 메서드 예제 =====");
		//사이즈는 용량을 넘을 수 없다. (용량 = 최대크기 / 사이즈 = 해당 데이터가 차지하고 있는 크기)
		
		Vector v = new Vector(5); //용량이 5인(사이즈는 0) 벡터 생성
			//사용할 공간이 적을 때 default로 넣으면 메모리가 낭비된다.
		
		v.add("홍길동");
		v.add("이순신");
		v.add("3");
		print(v);
		System.out.println();

		
		System.out.println("====== After trimToSize() ======");
		v.trimToSize();		//벡터의 용량을 현재 벡터 사이즈로 줄인다.
		print(v);
		System.out.println();
		
		v.ensureCapacity(5);		// 현재 용량이 최소 용량보다 작다면, 신규 용량 = 현재 용량 * 2;
		//= 최소용량이 5보다 작으면 안 된다.	// 그래도 최소 용량보다 작다면, 신규 용량 = 최소용량으로 설정된다.;
									// (※ 만약 *2를 했는데 5보다 작을 경우)
		
		System.out.println("=== After ensureCapacity(5) ====");
		print(v);
		v.setSize(7);				// 현재 용량이 설정 사이즈보다 작으면, 신규 용량 = 현재 용량 * 2
		//= 사이즈를 뭐든간에 7로 만든다.	// 그래도 작다면 신규 용량 = 설정 사이즈로 설정됨.
									// (※ 설정한 사이즈보다 용량이 적을 경우, 용량을 두 배로 늘린다.)
		System.out.println();
		
		System.out.println("======= After setSize(7) =======");
		print(v);
		System.out.println();
		
		v.clear();
		System.out.println("======== After clear() =========");
		print(v);
		System.out.println();
		
		
		
		
		
		
		
		
	}
	
	public static void print(Vector v) {
		System.out.println(v);
		System.out.println("size: " + v.size());
		System.out.println("capacity: " + v.capacity());
		
	}
	
}

