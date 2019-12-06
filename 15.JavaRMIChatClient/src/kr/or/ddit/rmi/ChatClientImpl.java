package kr.or.ddit.rmi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

import kr.or.ddit.rmi.inf.ChatClient;
import kr.or.ddit.rmi.inf.ChatServer;

@SuppressWarnings("serial")
public class ChatClientImpl extends UnicastRemoteObject implements ChatClient, Runnable {

	private ChatServer server = null;

	protected static String name = null;

	public ChatClientImpl(String name) throws RemoteException, Exception {

		ChatClientImpl.name = name;

		// 1. 등록된 서버를 찾기 위해 Registry객체를 생성한 후
		// 사용할 객체를 불러온다.
		Registry reg = LocateRegistry.getRegistry("192.168.0.44", 8888);

		server = (ChatServer) reg.lookup("RMIChatServer");

		server.addClient(this, name);

	}

	// 서버에서 RMI로 호출해준다.
		// UnicastRemoteObject 를 extends 해줬고, 인터페이스에서도 remote를 상속받았다.
		// registry 를 사용하진 않았지만 서버와 클라이언트는 서로의 기능 사용 가능
	public void printMessage(String msg) throws RemoteException {
	
		System.out.println(msg);     
	
	}  

	public void run() {

       BufferedReader br = null;

       try {

          br = new BufferedReader(new InputStreamReader(System.in));

          String message = null;

          while ((message = br.readLine())!= null) {

             server.say(""+ name +" : " + message);  

             if(message.equals("exit")){                  

            	// this: 나 자신의 객체를 파라미터로 넣어줬다. 닉네임도 넣어줬음.
        	 	server.disconnect(this, name);   

             }                   

          }

       }catch(Exception e) {

          System.out.println(e);

       }      

	}  

	public static void main(String[] args) throws Exception {
	   
	   String str = JOptionPane.showInputDialog("대화명을 입력하세요");
	   
       new Thread(new ChatClientImpl(str)).start();        

	}

}
