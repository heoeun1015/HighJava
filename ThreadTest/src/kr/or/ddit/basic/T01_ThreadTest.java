package kr.or.ddit.basic;

/**
 * 싱글 쓰레드 프로그램
 * @author pc16
 *
 */
public class T01_ThreadTest {
	public static void main(String[] args) {
		
		for(int i = 1; i <= 200; i++) {
			System.out.print("*");
		}System.out.println();

		for(int i = 1; i <= 200; i++) {
			System.out.print("$");
		}
		
	}
}
