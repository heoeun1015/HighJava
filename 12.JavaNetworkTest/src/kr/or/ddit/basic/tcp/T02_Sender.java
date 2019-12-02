package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

// 소켓을 통해서 메시지를 보내는 역할을 담당한다.
public class T02_Sender extends Thread{
	
	Socket socket;
	DataOutputStream dos;
	String name;
	
	public T02_Sender(Socket socket) {
		
		this.socket = socket;
		name = "[" + socket.getInetAddress() + ": " + socket.getPort() + "]";
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while(dos != null) {
			try {
				dos.writeUTF(name + " >>> " + scanner.nextLine());
				// 상대방에게 보내기 위해서 OutputStream 을 만들었으니 writeUTF를 써준다. 
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		scanner.close();
	}
	
}
