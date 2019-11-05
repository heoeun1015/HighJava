package kr.or.ddit.basic;

class Util2{	  
	public static <T extends Number> int compare(T t1, T t2) {
	// <> 타입만 적어주는 것이 아니고 extends한 Number 타입만 받게끔 제한을 건 것.
		double v1 = t1.doubleValue();	// 기본적으로 Number가 가지고 있는 메서드 
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2);	// 기본 오름차순 기준으로 정렬해준다.
		
	}
}

// 제한된 타입 파라미터(Bounded Parameter) 예제

public class T05_GenericMethod {
	public static void main(String[] args) {
		
		int result1 = Util2.compare(10, 20);		// AutoBoxing(객체화)
		System.out.println(result1);
		
		int result2 = Util2.compare(3.14, 3);
		System.out.println(result2);
		
//		Util2.compare("c", "java");	// 에러 발생 
		
		
	}
}
