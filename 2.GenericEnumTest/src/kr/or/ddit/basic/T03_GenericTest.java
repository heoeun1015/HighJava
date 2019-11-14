package kr.or.ddit.basic;


/*	제너릭 클래스를 만드는 방법
		 	
 	형식)
 	class 클래스명<제너립 타입 글자>{
 		제너릭 타입 글자 변수명;	// 변수 선언에 제너릭을 사용할 경우
 		…
 		
 		제너릭 타입 글자 메서드명(){ // 반환값이 있는 메서드에서 사용
 			…
 			
 			return 값;
 		}
 		…
 	} 
 	
 	
 	<< 제너릭타입 글자 >>
 	
 	- T → Type
 	- K → Key
 	- V → Value
 	- E → Element(자료구조에 들어가는 것들을 나타낼 때 사용)
 	
 	※ 아무거나 써도 상관은 없는데 가능한 의미를 알 수 있도록 쓰는 것이 좋다. */



class NongenericClass{
	private Object val;
	
	public Object getVal() {
		return val;
	}
	
	public void setVal(Object val) {
		this.val = val;
	}
	
}

class MyGeneric<T>{	// 컴파일 하는 시점까지만 타입을 지정해주면 된다. 지정은 해줘야 함. T가 뭔지 알게 뭐야 컴파일러가..
	private T val;
	
	public T getVal() {
		return val;
	}
	
	public void setVal(T val) {
		this.val = val;
	}
	
}
public class T03_GenericTest {
	public static void main(String[] args) {
		
		NongenericClass ng1 = new NongenericClass();
		ng1.setVal("가나다라");
		// ng1.setVal(100); 	// Integer를 넣으면 캐스팅 때 컴파일 에러 
		
		NongenericClass ng2 = new NongenericClass();
		ng2.setVal(100);
		
		
		// 캐스팅을 계속 해주어야 함. 시스템상으로 부담을 준다. 
		String rtnNg1 = (String)ng1.getVal();
		System.out.println("문자열 반환값 rtnNg1 → " + rtnNg1);
		
		Integer irtnNg2 = (Integer)ng2.getVal();
		System.out.println("정수 반환값 irtnNg2 → " + irtnNg2);
		System.out.println("───────────────────────────────────────");
		
		
		
		MyGeneric<String> mg1 = new MyGeneric<String>();
		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();
		// MyGeneric<Integer> mg2 = new MyGeneric<>(); // 다이아몬드 문법
		
		
		mg1.setVal("우리나라");
//		mg1.setVal(100);		// 컴파일 에러
		mg2.setVal(500);
		
		// 캐스팅을 따로 해주지 않아도 된다.
		rtnNg1 = mg1.getVal();
		irtnNg2 = mg2.getVal();
		
		System.out.println("제너릭 문자열 반환값(변수): " + rtnNg1);
		System.out.println("제너릭 문자열 반환값: " + mg1.getVal());
		System.out.println("제너릭 정수형 반환값(변수): " + irtnNg2);
		System.out.println("제너릭 정수형 반환값: " + mg2.getVal());
		
	}
}


















