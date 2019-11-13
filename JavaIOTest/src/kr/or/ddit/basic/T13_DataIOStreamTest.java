package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 기본타입 입출력 보조 스트림 예제
public class T13_DataIOStreamTest {
	public static void main(String[] args) {
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/D_Other/test.dat");
			
			// ■ DataOutputStream
			// DataOutputStream 은 출력용 데이터를 자료형에 맞게 출력해준다.
			DataOutputStream dout = new DataOutputStream(fout); 
			
			dout.writeUTF("홍길동");		// 문자열 데이터 출력 UTF-8	
			dout.writeInt(17);			// 정수형으롣 데이터 출력
			dout.writeFloat(3.14f);		// 실수형(Float)으로 출력
			dout.writeDouble(3.14);		// 실수형(Double)으로 출력
			dout.writeBoolean(true);	// 논리형으로 출력
			System.out.println("▷ 출력 완료");
			
			dout.close();
			
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
			
			// 출력한 자료 읽어오기
			
			// ■ DataInputStream
			FileInputStream fin = new FileInputStream("d:/D_Other/test.dat");
			DataInputStream din = new DataInputStream(fin);	// 데이터를 읽어들이는데 필요한 보조 스트링
			
			// 출력 순서를 바꾸면 오류가 난다. 각 자료형의 크기가 다르기 때문에, 출력했을 때의 순서를 염두에 두어야 함.
			System.out.println("문자열 자료: " + din.readUTF());
			System.out.println("정수형 자료: " + din.readInt());
			System.out.println("실수형(Float) 자료: " + din.readFloat());
			System.out.println("실수형(Double) 자료: " + din.readDouble());
			System.out.println("논리형 자료: " + din.readBoolean());
			
			din.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
