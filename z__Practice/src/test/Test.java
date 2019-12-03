package test;

import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test {
	public static void main(String[] args) throws Exception {
		
		
		for(int i = 0; i < 20; i++) {
			int str = (int)(Math.random() * 999999) + 1;
			System.out.println(str);
		}
		
	}
}
