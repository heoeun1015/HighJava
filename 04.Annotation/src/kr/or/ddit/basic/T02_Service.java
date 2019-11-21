package kr.or.ddit.basic;

// 애너테이션 사용 예제
public class T02_Service {

	
	@T01_PrintAnnotation()	// 특별한 값 세팅 X
	public void method1() {
		System.out.println("▷ 메서드 1에서 출력되었습니다.");
	}
	
//	@T01_PrintAnnotation(value = "%")	에서 아래는 value 를 생략해줬음.
	@T01_PrintAnnotation("%")	// 타입 요소 이름이 value 이고, %만 세팅해줄 때
	public void method2() {
		System.out.println("▷ 메서드 2에서 출력되었습니다.");
	}
	
	@T01_PrintAnnotation(value = "#", count = 25)
//	@T01_PrintAnnotation("#", count = 25)	: 다른 값이랑 세팅해줄 때는 반드시 타입을 명시해주어야 한다.
	public void method3() {
		System.out.println("▷ 메서드 3에서 출력되었습니다.");
	}
	
	// annotation 을 지운다고 해서 특별한 오류가 일어나진 않는다.

	
}
