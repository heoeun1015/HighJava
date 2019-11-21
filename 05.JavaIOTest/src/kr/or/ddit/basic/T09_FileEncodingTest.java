package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

	/*	InputStreamReader 객체는 파일의 인코딩 방식을 지정할 수 있다.
	 	형식) new InputStreamReader(바이트기반스트림 객체, 인코딩 방식)
	 	
	 	<< 인코딩 방식 >>
	 	한글 인코딩 방식은 크게 두 가지로 나뉜다. (UTF-8과 EUC-KR)
	 	원래 한글 윈도우는 CP949 방식을 사용했는데, 윈도우를 개발한 마이크로소프트에서 EUC-KR방식에서 확장하였기 때문에 MS949 라고도 부른다.
	 	CP949는 EUC-KR의 확장이며, 하위 호환성이 있다.
	 	// ansi로 저장하면 윈도우 기본 CP949로 저장이 된다. 
	 	
	 	- MS949 : 윈도우의 기본 한글 인코딩 방식(ANSI 계열)
	 	- UTF-8	: 유니코드 UTF-8 인코딩 방식(영문자 및 숫자: 1byte, 한글: 3byte)
	 	- US-ASCII	: 영문 전용 인코딩 방식
	 	
	 	ANSI는 영어를 표기하기 위해 만든 코드로 규격 자체에 한글이 없었다가 나중에 여기에 EUC-KR, CP949 라는 식으로 한글이 포함 됨.
	 	
	 	┌─────────────────────────────────────────────────────────────────┐
	 	│ 참고)	ASCII → extended ASCII(ISO 8859-1) → 조합형, 완성형(KSC 5601  │
	 	├─────────────────────────────────────────────────────────────────┤
	 	│	→ 윈도우 계열: CP949(확장 완성형)			→ 유니코드(Unicode)		  │
	 	│	→ 유닉스 계열: EUC-KR(확장 유닉스 코드)								  │
	 	└─────────────────────────────────────────────────────────────────┘ */


public class T09_FileEncodingTest {
	public static void main(String[] args) {
		
		// 파일 인코딩을 이용하여 읽어오기
		FileInputStream fin = null;
		InputStreamReader isr = null;
			// byte로 받았으므로 문자로 변환시켜줘야 함.
		
		try {
			// FileInpuStream 객체를 생성한 후 이 객체를 매개변수로 받는 InputStreamReader 객체를 생성한다.
//			fin = new FileInputStream("d:/D_Other/test_utf8.txt");
			fin = new FileInputStream("d:/D_Other/test_ansi.txt");
			
//			isr = new InputStreamReader(fin);	// 아무것도 설정하지 않으면 기본 유니코드 방식으로 처리한다.
			isr = new InputStreamReader(fin, "MS949");
			
			int c;
			while((c = isr.read()) != -1) {
				System.out.print((char)c);
			}
			
			System.out.println();
			System.out.println("▷ 출력 끝");
			
			isr.close();	// 보조스트림만 닫아도 된다.
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}

