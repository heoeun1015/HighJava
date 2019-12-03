package kr.or.ddit.basic.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class T01_UdpClient {
	private void start() throws IOException {
		
		DatagramSocket socket = new DatagramSocket();
		InetAddress serverAddr = InetAddress.getByName("127.0.0.1");
		
		// 데이터가 저장될 공간으로 byte 배열을 생성한다.
		byte[] msg = new byte[100];
		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddr, 8888);	// send
		DatagramPacket inPacket = new DatagramPacket(msg,  msg.length);				// receive
		
		socket.send(outPacket);		// DatagramPacket을 전송한다.
		socket.receive(inPacket);	// DatagramPacket을 수신한다. (현재 시간 데이터)
		
		System.out.println("▷ 현재 서버 시간: " + new String(inPacket.getData()));
		
		socket.close();
		
	}
	
	public static void main(String[] args) {
		try {
			new T01_UdpClient().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
