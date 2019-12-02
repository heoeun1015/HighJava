package kr.or.ddit.basic;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class T02_URLTest {
	public static void main(String[] args) throws IOException, URISyntaxException {
		
		// URL클래스 → 인터넷에 존재하는 서버들의 자원에 접근할 수 있는 주소를 관리하는 클래스
		
		// http://ddit.or.kr:80/index.html?ttt=123
		URL url = new URL("http", "ddit.or.kr", 80, "main/index.html?ttt=123#kkk");
		
		System.out.println("전체 URL 주소: http://ddit.or.kr:80/main/index.html?ttt=123#kkk");
			// ? 다음은 쿼리 스트링이라고 부른다.
		
		System.out.println("protocol: " + url.getProtocol());
		System.out.println("host: " + url.getHost());
		System.out.println("file: " + url.getFile());
		System.out.println("query: " + url.getQuery());
		System.out.println("path: " + url.getPath());	// 쿼리 스트링을 제외한 주소
		System.out.println("port: " + url.getPort());
		System.out.println("ref: " + url.getRef());
		System.out.println();
		
		System.out.println(url.toExternalForm());
		System.out.println(url.toString());
		System.out.println(url.toURI().toString());
		
	}
}
