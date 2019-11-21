package kr.or.ddit.basic;

// 속성값을 보기 위한 예제
public class T03_LambdaTest {
	
	static int stVar = 9;
	
	public void testMethod(final int temp) {
		
		final int localVar = 50;
//		int kor = 100;
		final int kor = 100;
		
		// 람다식 내부에서 사용되는 지역변수는 finally 이어야 한다.
		// 보통은 final을 붙이지 않으면 컴파일러가 자동으로 붙여준다.
		// 단, 지역변수의 값을 변경하는 식이 있을 경우에는 자동으로 final을 붙여주지 않는다.
		
		// temp = 50;
		// locvalVar = 2000;
//		kor = 400;	// final이 아니어서 final로 위에서 다시 선언하면 에러가 난다.
		
		// 람다식에서 지역변수 사용하기
		LambdaTestInterface1 lt = () ->{
			System.out.println("temp = " + temp);
			System.out.println("localVar = " + localVar);
			System.out.println("kor = " + kor);
			System.out.println("stVar = " + stVar);
		};
		lt.test();
		
	}
	
	
	public static void main(String[] args) {
		new T03_LambdaTest().testMethod(200);
	}
	
}
