package kr.or.ddit.basic.tcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class T04_TCPFileServer {

	// 서버는 클라이언트가 접속하면 서버 컴퓨터의 D:/D_Other/Tulips.jpg 파일을 클라이언트로 전송하낟.
	
	private ServerSocket server;
	private Socket socket;
	private OutputStream out;
	private FileInputStream fin;
	
	public void serverStart() {
		File file = new File("d:/D_Other/Tulios.jpg");

		try {
			server = new ServerSocket(7777);
			System.out.println("▷ 서버 준비 완료");

			socket = server.accept();

			System.out.println("▷ 파일 전송 시작");

			fin = new FileInputStream(file);
			out = socket.getOutputStream();


			// 한꺼번에 읽어와 전송할 데이터 저장변수 선언
			byte[] tmp = new byte[1024];

			int length = 0;
			while((length = fin.read(tmp)) != -1) {
				out.write(tmp, 0, length);
			}
			out.flush();

			System.out.println("▶ 파일 전송 완료");

		}catch (IOException e) {
		}finally {
			if(fin != null) {
				try {fin.close();} catch(IOException e) {}
			}
			if(out != null) {
				try {out.close();} catch(IOException e) {}
			}
			if(socket != null) {
				try {socket.close();} catch(IOException e) {}
			}
			if(server != null) {
				try {server.close();} catch(IOException e) {}
			}
		}
	}
	
	public static void main(String[] args) {
		new T04_TCPFileServer().serverStart();
	}
}











