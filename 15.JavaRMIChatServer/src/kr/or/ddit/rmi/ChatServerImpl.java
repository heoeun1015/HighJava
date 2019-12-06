package kr.or.ddit.rmi;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

import java.util.*;

import kr.or.ddit.rmi.inf.ChatClient;
import kr.or.ddit.rmi.inf.ChatServer;

public class ChatServerImpl extends UnicastRemoteObject implements ChatServer {

   Vector<ChatClient> clientList = new Vector<>();

   public ChatServerImpl() throws RemoteException{} 

   public static void main(String args[]){

       try{

          System.out.println("ChatServerImpl.main:creating registry");
          
          //System.setProperty("java.rmi.server.hostname","192.168.0.23");

          ChatServerImpl Server = new ChatServerImpl();    
          
          Registry reg = LocateRegistry.createRegistry(8888);

          reg.rebind("RMIChatServer", Server);
    //      Naming.rebind("RMIChatServer", Server);

          System.out.println("ChatServerImpl is running...");

       } catch (Exception e){

          System.out.println("ChatServerImpl error: " + e.getMessage());

          e.printStackTrace();

       }

   }

   		// 클라이언트가 실행할 메서드를 구현
   		// 상대방의 원격 객체를 파라미터로 받았다.
   public void addClient(ChatClient client, String name) throws RemoteException{

       clientList.addElement(client);

       say(name + "님이 접속하셨습니다.");

       System.out.println("New Client! Number of client = " + (clientList.size()));

   }

   public void disconnect(ChatClient client, String name) throws RemoteException{

       int i = clientList.indexOf(client);

       if (i >= 0){

          say(name + "님이 퇴장하셨습니다.");

          clientList.removeElementAt(i);
          // 관리하고 있는 원격 객체 삭제

          System.out.println("A Client exited! Number of client = " + clientList.size());

       }else {

          System.out.println("No such a client in Server! ");

       }

   }

   public void say(String msg) throws RemoteException {

       int numOfConnect = clientList.size();

       for(int i = 0; i < numOfConnect; i++){

    	   // 기능을 이해하면 확장 가능
	    	   // TCP: 소켓 정보를 가져다가 상대방 정보를 write 해줬었다.
	    	   // UDP: 데이터 그램 패킷으로 쏴준다.
	    	   // RMI: 호출한 원격 객체를 넣어놨다가 필요할 대 객체를 꺼내서 실행하는 순간 클라이언트의 객체가 실행되는 식
    	   
          ((ChatClient)clientList.elementAt(i)).printMessage(msg);

       }

   }

}
