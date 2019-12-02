package kr.or.ddit.basic.tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class T02_TCPServer2 {
	public static void main(String[] args) {
		
		// 서버소켓을 만들고, 클라이언트가 접속하면 소켓을 만들어 데이터를 받는 클래스와 데이터를 보내는 클래스에 이 소켓을 넘겨준다.
		// 스레드는 총 3개 돌고 있다. main / server / Receiver
		
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(7777);
			System.out.println("▷ 서버 준비 완료");
			socket = server.accept();	// 상대방 요청이 올 때까지 블락된다.
			
			T02_Sender sender = new T02_Sender(socket);
			T02_Receiver receiver = new T02_Receiver(socket);
			
			sender.start();
			receiver.start();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
