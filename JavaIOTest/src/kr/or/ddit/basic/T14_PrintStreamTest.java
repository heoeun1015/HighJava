package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

// 프린터기능 제공 보조 스트림 예제
public class T14_PrintStreamTest {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fout = new FileOutputStream("d:/D_Other/print.txt");
		FileOutputStream fout2 = new FileOutputStream("d:/D_Other/print2.txt");
		
		PrintStream out = new PrintStream(System.out);	// 콘솔을 기반 스트림으로 넣어준다.
//		PrintStream out2 = new PrintStream(fout2);	
		
		out.print("(1) 안녕하세요. PrintStream입니다.\n");
		out.println("(2) 안녕하세요. PrintStream입니다.");
		out.println("(3) 안녕하세요. PrintStream입니다.");
		
		out.close();
		
//		PrintWriter writer = new PrintWriter(fout);
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(fout, "UTF-8"));
		writer.print("(1) 안녕하세요. PrintWriter입니다.\r\n");
		writer.println("(2) 안녕하세요. PrintWriter입니다.");
		writer.println("(3) 안녕하세요. PrintWriter입니다.");
		
		writer.close();
		
	}
}
