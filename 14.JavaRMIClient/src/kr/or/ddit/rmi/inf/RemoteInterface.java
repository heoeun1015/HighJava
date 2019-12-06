package kr.or.ddit.rmi.inf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import kr.or.ddit.rmi.vo.FileInfoVO;
import kr.or.ddit.rmi.vo.TestVO;

// RMI용 인터페이스는 Remote를 상속해야 한다.
public interface RemoteInterface extends Remote{

	/*	이 인터페이스에서 선언된 모든 메서드는 RemoteException을 throw 해야 한다.
	 	이 곳에서 선언된 메서드의 파라미터 변수는 클라이언트에서 보내오는 데이터가 저장되고,
	 	반환값은 서버에서 클라이언트 쪽으로 보내는 데이터가 된다.	 */
	
	// RMI를 사용하기 위해서는 client의 경우 server와 동일한 vo와 interface를 사용해야 한다.
	
	// 반드시 throws RemoteException 를 붙여줄 것.
	public int doRemotePrint(String str) throws RemoteException;
	
	public void doPrintList(ArrayList<String> list) throws RemoteException;
	
	public void doPrint(TestVO vo) throws RemoteException;
	
	// 파일 전송을 위한 메서드
	public void setFiles(FileInfoVO[] finfo) throws RemoteException;
	
}
