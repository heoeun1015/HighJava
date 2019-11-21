package test;

import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test {
	public static void main(String[] args) throws Exception {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		
		FileOutputStream fos1 = new FileOutputStream("d:/D_Other/out_urf8.txt");
//		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/out_ansi.txt");
		
		OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "utf-8");
//		OutputStreamWriter osw2 = new OutputStreamWriter(fos1, "ms949");
		
		int c;
		
		System.out.println("아무거나 입력하세요.");
		while((c = isr.read()) != -1) {
			osw1.write(c);
//			osw2.write(c);
		}
		
		isr.close();
		osw1.close();
//		osw2.close();
	}
}
