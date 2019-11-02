package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T15_HotelManageTest {
	
	private Scanner s;
	private Map<String, Hotel> HotelManage;
	
	public T15_HotelManageTest() {
		s = new Scanner(System.in);
		HotelManage = new HashMap<>();
	}

	public void MainMenu(){
		
		Scanner s = new Scanner(System.in);
		
		int menu = 0;
		
		System.out.println("▷ 호텔 문을 열었습니다.");
		
		do {
			
			System.out.println("─────────────────────────────────────");
			System.out.println("1.체크인 / 2.체크아웃 / 3.객실상태 / 4.업무종료");
			System.out.println("─────────────────────────────────────");
			System.out.print("▷ 어떤 업무를 하시겠습니까?: ");
			
			switch(menu) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomState();
				break;
			case 4:
				System.out.println("▷ 호텔 문을 닫았습니다.");
				break;
			default:
				System.out.println("▷ 다시 선택해주세요.");
				break;
			}
			
			
			
		}while(true);
		
		
		
	}

	private void checkIn() {
		
		System.out.println(" (방 번호 형식: 세 자리 숫자)");
		System.out.println("▷ 어느 방에 체크인 하시겠습니까?");
		
		int roomNum = Integer.parseInt(s.nextLine());
		
		if(roomNum == )
		
		
	}

}

class Hotel{
	
	private int roomNum;
	private String name;
	
	public Hotel(int roomNum, String name) {
		super();
		this.roomNum = roomNum;
		this.name = name;
	}

	
	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
