package kr.or.ddit.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class T03_AnnotationTest {
	// 서비스에 붙여놓은 애너테이션 정보를 가져와 구현하고 있다.
	public static void main(String[] args) throws Exception {
		
		System.out.println(T01_PrintAnnotation.id);
		System.out.println("────T01_PrintAnnotation.id────");
		System.out.println();
		
		// reflection 기능을 이용한 메서드 실행
		Method[] declaredMethods = T02_Service.class.getDeclaredMethods();
									// getDeclaredMethods를 부르면 Method 타입의 배열 객체가 리턴이 된다. 
		
		for(Method m : declaredMethods) {
			System.out.println(m.getName());	// 메서드명 출력 (100, method1)
//			System.out.println("─────────────m.getName()─────────────");
			for(int i = 0; i < m.getDeclaredAnnotation(T01_PrintAnnotation.class).count(); i++) {
				// PrintAnnotation의 count값 만큼...
				System.out.print(m.getDeclaredAnnotation(T01_PrintAnnotation.class).value());
				// PringAnnotation의 value값 출력
			}
			System.out.println();		// 줄바꿈 처리
			System.out.println("──────────────────────────────");
			
			m.invoke(new T02_Service());
		}
		
	}
}
