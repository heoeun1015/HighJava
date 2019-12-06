package kr.or.ddit.rmi.client;

import java.io.File;
import java.io.FileInputStream;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import kr.or.ddit.rmi.inf.RemoteInterface;
import kr.or.ddit.rmi.vo.FileInfoVO;
import kr.or.ddit.rmi.vo.TestVO;

// 클라이언트 쪽의 프로젝트에도 서버의 패키지와 같은 구조로 Interface와 VO파일이 있어야 한다.
public class RemoteClient {
	public static void main(String[] args) {
		
		// Registry 서버에 등록된 객체를 구한다.
		try {
			// 1. 등록된 서버를 찾기 위해 Registry 객체를 생성한 후 사용할 객체를 불러온다.
			Registry reg = LocateRegistry.getRegistry("192.168.0.3", 8888);
			
			RemoteInterface clientInf = (RemoteInterface) reg.lookup("server");
			
			// 이제부터는 불러온 객체의 메서드를 호출해서 사용할 수 있다.
			int a = clientInf.doRemotePrint("▷ 안녕하세요."); // 서버에서 제공하고 있는 원격 객체
			System.out.println("▷ 반환값 → " + a);
			System.out.println("───────────────────────────────────────");
			
			ArrayList<String> list = new ArrayList<String>();
			list.add("대전");
			list.add("대구");
			list.add("광주");
			list.add("인천");
			clientInf.doPrintList(list);
			System.out.println("▶ List 호출 끝");
			System.out.println("───────────────────────────────────────");
			
			TestVO vo = new TestVO();
			vo.setTestId("홍길동");
			vo.setTestNum(1234);
			clientInf.doPrint(vo);
			System.out.println("▶ VO 출력 메서드 호출 끝");
			System.out.println("───────────────────────────────────────");
			
			// 파일 전송하기
			FileInputStream fin;
			File[] files = new File[2];
			files[0] = new File("d:/D_Other/Desert.jpg");
			files[1] = new File("d:/D_Other/Tulips_PC16.jpg");
			
			FileInfoVO[] fInfo = new FileInfoVO[files.length];
			
			// 2개의 파일을 읽어서 byte[]에 담아서 서버측 메서드에 전달하면 된다.
			for(int i = 0; i < files.length; i++) {
				int len = (int) files[i].length();		// 파일 길이 구하기
				fin = new FileInputStream(files[i]);
				byte[] data = new byte[len];
				
					// 버퍼에 넣어주는 과정. 파일 사이즈만큼의 버퍼를 만들어뒀다.
				fin.read(data);		// 파일 내용을 읽어서 byte형 배열에 저장
				fInfo[i] = new FileInfoVO();
				fInfo[i].setFileData(data);		// 파일 데이터 저장
				fInfo[i].setFileName(files[i].getName());		// 파일이름
			}
			
			clientInf.setFiles(fInfo);		// 서버에 파일 저장하는 메서드 호출
			System.out.println("▶ 파일 전송 작업 끝");
			System.out.println("───────────────────────────────────────");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
