package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class T01_InetAdressTest {
	public static void main(String[] args) throws UnknownHostException {
		// InetAddress 클래스 → IP주소를 다루기 위한 클래스
		
		// naver사이트의 ip정보 가져오기
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
			// String으로 안하고 InetAddress 객체 타입으로 관리한다.
		
		System.out.println("Host Name → " + naverIp.getHostName());
		System.out.println("Host Address → " + naverIp.getHostAddress());
		System.out.println();
		
		// 자기 자신 컴퓨터의 IP 주소 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 Host Name → " + localIp.getHostName());
		System.out.println("내 컴퓨터의 Host Address → " + localIp.getHostAddress());
		System.out.println();
		
		// ip주소가 여러개인 호스트의 정보 가져오기
		InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
		for(InetAddress nIp : naverIps) {
			System.out.println(nIp.toString());
		}
		
	}
}
