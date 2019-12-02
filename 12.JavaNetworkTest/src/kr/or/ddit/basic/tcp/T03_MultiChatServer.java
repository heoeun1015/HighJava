package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class T03_MultiChatServer {
	
	// 대화명, 클라이언트의 Socket을 저장하기 위한 Map 변수 선언
	Map<String, Socket> clients;
	
	// 생성자
	public T03_MultiChatServer() {
		// 동기화 처리가 가능하도록 Map 객체 생성
		clients = Collections.synchronizedMap(new HashMap<>());
	}
	
	// 비지니스 로직을 처리하는 메서드
	public void serverStart() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("▷ 서버가 시작되었습니다.");
			
			while(true) {
				// 클라이언트의 접속을 대기한다.
				socket = serverSocket.accept();
				
				System.out.println("[" + socket.getInetAddress() + ": " + socket.getPort() + "] 에서 접속하였습니다.");
				
				// 메세지 전송 처리를 하는 쓰레드 생성 및 실행
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 서버 소켓 닫기
			if(serverSocket != null) {
				try {
					serverSocket.close();
				}catch(IOException e) {}
			}
		}
	}
	
	
	// 대화방 즉, Map에 저장된 전체 유저에게 메세지를 전송하는 메서드
		// 소켓 값이 저장되어 있기 때문에 대화명을 알면 getInput, Output으로 넣고 뺄 수 있다. 
	public void sendToAll(String msg) {
		// Map에 저장된 유저의 대화명 리스트 출력(key값 구하기)
		Iterator<String> it = clients.keySet().iterator();
			// String: 대화명
		while(it.hasNext()){
			try {
				String name = it.next();	// 대화명(key값) 구하기

				// 대화명에 해당하는 Socket의 OutputStream 객체 구하기
				DataOutputStream out = new DataOutputStream(clients.get(name).getOutputStream());

				out.writeUTF(msg);		// 메세지 보내기

			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	}
	

	// 서버에서 클라이언트로 메세지를 전송할 Thread를 Inner클래스로 정의
	// Inner클래스에서는 부모클래스의 멤버들을 직접 사용할 수 있다.
	class ServerReceiver extends Thread{
		
		Socket socket;
		DataInputStream dis;
		
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				// 수신용
				dis = new DataInputStream(socket.getInputStream());
			}catch(IOException e) {
				
			}
		}
		
		@Override
		public void run() {
			String name = "";
			try {
				// 서버에서는 클라이언트가 보내는 최초의 메세지, 즉 대화명을 수신해야 한다.
					// 소켓 접속하자마자 바로 보내준게 대화명이기 때문
					// 대화명을 저장하기 위한 프로그램이므로 일단 저장하고 본다.
				name = dis.readUTF();
				
				// 대화명을 받아서 모든 클라이언트에게 대화방 참여 메세지를 보낸다.
				sendToAll("▶ #" + name + "님이 입장했습니다.");
				
				// 대화명과 소켓정보를 Map에 저장한다.
				clients.put(name, socket);
					// 방금 들어온 사람의 소켓 정보를 put으로 집어넣는다.
				System.out.println("▷ 현재 서버 접속자 수는 " + clients.size() + "명 입니다.");
				
				// 이 후의 메세지 처리는 반복문으로 처리한다.
				// 한 클라이언트가 보낸 메세지를 다른 모든 클라이언트에게 보내준다.
				while(dis != null) {
					sendToAll(dis.readUTF());
					// writeUTF 로 쓴 걸 읽고 바로바로 보내준다. 이 역할을 서버가 해주고 있음.
					// 계속 돌면서 readUTF 하고 있음.
				}
				
			}catch (Exception e) {
				
			}finally {
				// 이 finally 영역이 실행된다는 것은 클라이언트의 접속이 종료되었다는 의미이다.
				sendToAll("▶ " + name + "님이 나가셨습니다.");
				
				// Map에서 해당 대화명을 삭제한다.
				clients.remove(name);
				
				System.out.println("▷ [ " + socket.getInetAddress() + ": " + socket.getPort() + " ] 에서 접속을 종료했습니다.");
				System.out.println("▷ 현재 접속자 수는 " + clients.size() + "명 입니다.");
			}
		}
		
	}
	
	public static void main(String[] args) {
		new T03_MultiChatServer().serverStart();
	}

}
