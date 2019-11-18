package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T1_T14_PhoneBookTest {
	
	private Scanner s;
	private Map<String, Phone> phoneBookMap;
	
	public T1_T14_PhoneBookTest() {
		s = new Scanner(System.in);
		phoneBookMap = new HashMap<>();
	}
	
	public void displayMenu(){
		System.out.println();
		System.out.println("\t  ▷ 메뉴를 선택하세요.");
		System.out.println("\t 1. 전화번호 등록");
		System.out.println("\t 2. 전화번호 수정");
		System.out.println("\t 3. 전화번호 삭제");
		System.out.println("\t 4. 전화번호 검색");
		System.out.println("\t 5. 전화번호 전체 출력");
		System.out.println("\t 0. 프로그램 종료");
		System.out.println();
		System.out.print("\t  ▷ 번호입력: ");		
	}
	
	// 프로그램을 시작하는 메서드
	public void phoneBookStart(){
		System.out.println("───────────────────────────────────────────────");
		System.out.println("   전화번호 관리 프로그램(파일로 저장되지 않음)");
		System.out.println("───────────────────────────────────────────────");
		
		while(true){
			
			displayMenu();  // 메뉴 출력
			
			int menuNum = s.nextInt();   // 메뉴 번호 입력
			
			switch(menuNum){
				case 1 : 
//					insert();		// 등록
					break;
				case 2 : 
//					update();		// 수정
					break;
				case 3 : 
//					delete();		// 삭제
					break;
				case 4 : 
//					search();		// 검색
					break;
				case 5 : 
//					displayAll();	// 전체 출력
					break;
				case 0 :
					System.out.println("▷ 프로그램을 종료합니다.");
					return;
				default :
					System.out.println("▷ 잘못 입력했습니다. 다시입력하세요.");
			} // switch문
		} // while문
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

class Phone{
	
	private String name;
	private String tel;
	private String addr;
	
	public Phone(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
	
}