package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04_ByteArrayIOTest {
	public static void main(String[] args) /*throws IOException*/ {
		
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4];	// 자료를 읽을 때 사용할 배열
		
		
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		
		try {
			// available(): 읽어올 수 있는 byte수를 반환
			while(input.available() > 0) {	// read도 가능하고 available도 가능하다. 무조건 이걸 써야 한다는 아님.
				
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
				
				/*	temp: [0, 1, 2, 3]
				temp: [4, 5, 6, 7]
				temp: [8, 9, 6, 7]
				: 마지막 6, 7은 재활용한 temp 이기 때문에 들어가는 쓰레기 데이터.		*/
				
//				input.read(temp);	// temp 배열 크기만큼 읽어와 temp에 저장
//				output.write(temp);	// temp 배열 내용 출력
				
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
				
				// 실제 읽어온 byte 수를 반환한다.
				int len = input.read(temp);
				
				// temp 배열의 내용 중에서 0번째부터 len 개수만큼 출력한다.
				output.write(temp, 0, len);	// 0부터 len 까지 읽을 것. 다 읽으면 그 뒤는 무시한다.
				
				System.out.println("temp: " + Arrays.toString(temp));
			}
			
			
			System.out.println();
			outSrc = output.toByteArray();
			
			System.out.println("inSrc → " + Arrays.toString(inSrc));
			System.out.println("outSrc → " + Arrays.toString(outSrc));
			
			input.close();
			output.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
