package kr.or.ddit.basic.tcp;

import java.io.IOException;
import java.net.Socket;

public class T02_TCPClient2 {
	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket("127.0.0.1", 7777);
		
		T02_Sender sender = new T02_Sender(socket);
		T02_Receiver receiver = new T02_Receiver(socket);
		
		sender.start();
		receiver.start();
		
	}
}
