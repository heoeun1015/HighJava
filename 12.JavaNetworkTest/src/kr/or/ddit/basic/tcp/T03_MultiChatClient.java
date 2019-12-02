package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class T03_MultiChatClient {
	
	private String ninkName;	// 대화명
	
	// 비지니스 로직 처리
	public void clientStart() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("▷ 대화명: ");
		ninkName = scan.next();
		
//		scan.close();
		
		Socket socket = null;
		
		try {
//			String serverIp = "127.0.0.1";
			String serverIp = "192.168.0.3";
			socket = new Socket(serverIp, 7777);
				// 연결 잘 되면 아래로 내려감. 그냥 봐도 알 것 같지만 일단 써놓자.
			
			System.out.println("▷ 서버에 연결되었습니다.");
			
			// 송신용 쓰레드 생성
			ClientSender sender = new ClientSender(socket, ninkName);
			
			// 수신용 쓰레드 생성
			ClientReceiver receiver = new ClientReceiver(socket);
			
			// 쓰레드 실행
			sender.start();
			receiver.start();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	// 메세지를 전송하는 Thread
	class ClientSender extends Thread{
		// 사용자 입력이 있으면 무한루프를 도는 스레드
		
		Socket socket;
		DataOutputStream dos;
		String name;
		Scanner scan = new Scanner(System.in);
		
		public ClientSender(Socket socket, String name) {
			this.socket = socket;
			this.name = name;
			
			try {
				dos = new DataOutputStream(socket.getOutputStream());
			}catch (IOException e) {
				
			}
		}
		
		
		@Override
		public void run() {
			try {
				// 시작하자마자 자신의 대화명을 서버로 전송
				if(dos != null) {
					dos.writeUTF(name);	// 네임을 보내고 있다.
				}
				while(dos != null) {
					// 키보드로 입력받은 메세지를 서버로 전송
					dos.writeUTF("[" + name + "] " + scan.nextLine());
				}
			}catch (IOException e) {}
		}	
	} // 송신용 쓰레드 끝
	
	
	// 수신용 thread 클래스 정의
	class ClientReceiver extends Thread{
		
		Socket socket;
		DataInputStream dis;
		
		// 생성자
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				dis = new DataInputStream(socket.getInputStream());
			}catch (IOException e) {}
		}
		
		@Override
		public void run() {
			while(dis != null) {
				try {
					// 서버로부터 수신한 메세지 출력하기
					System.out.println(dis.readUTF());
				}catch (IOException e) {}
			}
		}
	}
	
	public static void main(String[] args) {
		new T03_MultiChatClient().clientStart();
		// 시작하면 메인은 끝나고 Send / Receive 가 돌게 된다.
	}
	
	
}



