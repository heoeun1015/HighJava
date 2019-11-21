package kr.or.ddit.basic;

// 함수적 인터페이스 → 추상메서드가 1개뿐인 인터페이스
@FunctionalInterface // 조금 더 정확하게 써주는 구문. 추상메서드 2개를 선언할 수 없다.
public interface LambdaTestInterface1 {
	// 반환값이 없고 매개변수도 없는 추상메서드 선언
	public void test();
}

@FunctionalInterface
interface LambdaTestInterface2 {
	// 반환값이 없고 매개변수가 있는 추상 메서드 선언
	public void test(int a);
}

@FunctionalInterface
interface LambdaTestInterface3 {
	// 반환값이 있고 매개변수도 있는 추상메서드 선언
	public int test(int a, int b);
}



