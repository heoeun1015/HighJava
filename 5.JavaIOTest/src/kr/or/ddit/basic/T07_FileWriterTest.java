package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.InputStreamReader;

public class T07_FileWriterTest {
	public static void main(String[] args) {
		
		// 사용자가 입력한 내용을 그대로 파일로 저장하기
		
		// 콘솔(표준입출력 장치)과 연결된 입력용 문자 스트림 생성
		// InputStreamReader 스트림 → 바이트기반 스트림을 문자기반 스트림으로 변환해주는 보조 스트림
		
		InputStreamReader isr = new InputStreamReader(System.in);
			// 혼자서 사용하지 못하므로 기반 스트링이 있어야 함. (System.in)
			// byte로 온 문자를 문자 기반으로 바꿔준다.
		
		FileWriter fw = null;	// 파일 출력용 문자기반 스트림
		
		try {
			// 파일 출력용 문자 스트림 객체 생성
			fw = new FileWriter("d:/D_Other/testChar.txt");
			
			int c;
			
			System.out.println("▷ 아무거나 입력하세요.");
			
			// 콘솔에서 입력할 때 입력의 끝 표시는 Ctrl + Z키를 누르면 된다.
			while((c = isr.read()) != -1) {
				fw.write(c);	// 콘솔에서 입력받은 값을 파일에 출력하기
					// 캐릭터 단위로 읽기 때문에 글자가 깨지지 않는다. byte 단위로 하면 1byte를 넘어가기 때문에 한글이 다 깨짐.
					// Ctrl + z를 누르는 순간 -1로 바뀌면서 while문을 빠져나온다.
			}
			
			System.out.println("▷ 작업 끝");
			
			isr.close();
			fw.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
