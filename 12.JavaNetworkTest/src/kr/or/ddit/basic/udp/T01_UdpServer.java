package kr.or.ddit.basic.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T01_UdpServer {
	private void start() throws IOException {
		
		// 포트 8888번을 사용하는 소켓을 생성한다.
		DatagramSocket socket = new DatagramSocket(8888);	// 데이터를 던지고 받을 때
		DatagramPacket inPacket, outPacket;					// 데이터를 담는 그릇
		
		byte[] inMsg = new byte[10];
		byte[] outMsg;
		
		while(true) {
			
			// 데이터를 수신하기 위한 패킷을 생성한다.
			inPacket = new DatagramPacket(inMsg, inMsg.length);	// inMsg.length: 받을 사이즈 정보
			
			// 패킷을 통해 데이터를 수시한다.
			socket.receive(inPacket);
			
			// 수신한 패킷으로부터 client의 IP주소와 Port를 얻는다.
				// TCP 방식에선 필요가 없었다. 연결을 지향하지 않기 때문에 사용.
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();
			
			// 서버의 현재 시간을 시분초 형태([hh:mm:ss])로 반환한다.
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			outMsg = time.getBytes();		// time을 byte 배열로 변환한다.
			
			// 패킷을 생성해서 client에게 전송(send)한다.
				// 보낼 때는 어떤 IP에 포트로 보낼지 알아야 하기 때문에 뒤 두 개를 더 써줬다. 
			outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
			socket.send(outPacket);
			
		}
	}
	
	public static void main(String[] args) {
		try {
			new T01_UdpServer().start();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}

