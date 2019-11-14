package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class T06_FileStreamTest {
	public static void main(String[] args) {
		
		// 파일에 출력하기
		FileOutputStream fout = null;

		try {
			// 출력용 OutputStream 객체 생성
			fout = new FileOutputStream("d:/D_Other/out.txt");

			for(char ch = 'a'; ch <= 'z'; ch++) {
				fout.write(ch);
			}
			System.out.println("▷ 파일 쓰기 작업 완료");

			// 쓰기 작업 완료 후 스트림 닫기
			fout.close();	// 자원반환

			// 저장된 파일의 내용을 읽어와 화면에 출력하기
			FileInputStream fin = new FileInputStream("d:/D_Other/out.txt");

			int c;
			while((c = fin.read()) != -1) {
				System.out.print((char)c);
			}
			System.out.println();
			System.out.println("▷ 출력 끝");
			fin.close();

		}catch(FileNotFoundException e) {
			System.out.println("▶ 존재하지 않는 파일입니다.");
		}catch(IOException e) {
			System.out.println("▶ 알 수 없는 오류");
		}
		
	}
}
