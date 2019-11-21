package kr.or.ddit.basic;

public class T02_LambdaTest {
	public static void main(String[] args) {
		
		/*
		// 람다식을 사용하지 않았을 경우 
		LambdaTestInterface1 lam1 = new LambdaTestInterface1() {
			
			@Override
			public void test() {
				System.out.println("▷안녕하세요.");
				System.out.println("▷ 익명 구현 객체 방식입니다.");
			}
		};
		*/
		
		LambdaTestInterface1 lam1 = () -> {
			System.out.println("▶ 반가워요. \n▶ 람다식으로 처리하는 방식입니다.");
		};
		lam1.test();
		System.out.println("───────────────────────────────────────");
		
		
		LambdaTestInterface2 lam3 = (int z) -> { // (int z) 생략 가능
			int result = z + 100;
			System.out.println("result = " + result);
		};
		lam3.test(30);
		System.out.println("───────────────────────────────────────");
		
		
		LambdaTestInterface2 lam4 = z -> {	// z 생략 가능
			int result = z + 300;
			System.out.println("result = " + result);
		};
		lam4.test(40);
		
		
		LambdaTestInterface2 lam5 = z -> System.out.println("result = " + (z + 500));
		lam4.test(90);
		System.out.println("───────────────────────────────────────");
		
		
		LambdaTestInterface3 lam6 = (int x, int y) -> {
			int r = x + y;
			return r;
		};
		int k = lam6.test(20, 50);
		System.out.println("k = " + k);
		
		
		LambdaTestInterface3 lam7 = (x, y) -> {		// 타입 생략 가능
			return x + y;
		};
		k = lam7.test(80, 50);
		System.out.println("k = " + k);
		
		
		LambdaTestInterface3 lam8 = (x, y) -> x + y;	// 중괄호, 리턴 생략
		k = lam8.test(100, 200);
		System.out.println("k = " + k);
		
		
		LambdaTestInterface3 lam9 = (x, y) -> {return x > y ? x : y;};	// 삼항 연산자는 생략 X 중괄호를 써줘야 한다.
		k = lam9.test(100, 200);
		System.out.println("k = " + k);
		
		
	}
}
















