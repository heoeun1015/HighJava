package kr.or.ddit.main;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;
	
public class MemberMain {

	private IMemberService service;
	
	private Scanner scan = new Scanner(System.in);
	
	public MemberMain() {
		service = MemberServiceImpl.getInstatnce();
	}

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start(){
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
			case 1 :  // 자료 입력
				insertMenu();
				break;
			case 2 :  // 자료 삭제
				deleteMember();
				break;
			case 3 :  // 자료 수정
				updateMember();
				break;
			case 4 :  // 전체 자료 출력
				displayMemberAll();
				break;
			case 5 :  // 작업 끝
				System.out.println("▶ 작업을 마칩니다.");
				break;
			default :
				System.out.println("▶ 번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=5);
	}

	// 회원정보를 삭제하는 메서드(입력받은 회원ID를 이용하여 삭제한다.)
	private void deleteMember() {
		
		System.out.println();
		System.out.print("▷ 삭제할 회원ID를 입력해주세요.");
		String memId = scan.next();
		
		int cnt = service.deleteMember(memId);
		
		if(cnt > 0) {
			System.out.println();
			System.out.println("▶ \"" + memId + "\"님의 정보를 삭제했습니다.");
		}else {
			System.out.println();
			System.out.println("▶ \"" + memId + "\"님의 정보를 삭제하는데 실패했습니다.");
		}
		
	}

	
	// 회원정보를 수정하는 메서드
	private void updateMember() {

		System.out.println();
		String memId = "";
		boolean chk = true;

		do {
			System.out.print("▷ 수정할 회원ID를 입력하세요.: ");
			memId = scan.next();

			chk = service.getMember(memId);
			if(chk == false) {
				System.out.println("▷ \"" + memId + "\"님의 회원정보가 없습니다.");
				System.out.println("▷ 수정할 자료가 없으니 다시 입력하세요.");
			}
		}while(chk == false);
		
		System.out.println();
		System.out.println("▷ 수정할 내용을 입력하세요.");
		System.out.print("▷ 수정할 이름: ");
		String memName = scan.next();
		
		System.out.print("▷ 수정할 전화번호: ");
		String memTel = scan.next();
		
		scan.nextLine();
		System.out.print("▷ 수정할 주소: ");
		String memAddr = scan.nextLine();
		

		MemberVO mv = new MemberVO();
		mv.setMem_id(memId);
		mv.setMem_name(memName);
		mv.setMem_tel(memTel);
		mv.setMem_addr(memAddr);
		
		
		
		int cnt = service.updateMember(mv);
		
		
		if(cnt > 0) {	// 업데이트가 잘 됐다.
			System.out.println();
			System.out.println("▶ \"" + memId + "\"님의 정보를 수정했습니다.");
		}else {
			System.out.println();
			System.out.println("▶ \"" + memId + "\"님의 정보를 수정하는데 실패했습니다.");
		}

	}

	// 전체 회원을 출력하는 메서드
	private void displayMemberAll() {

		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println(" ID\t이름\t전화번호\t\t주소");
		System.out.println("------------------------------------------");

		List<MemberVO> memList = service.getAllMemberList();
		
		for(MemberVO mv : memList) {
			System.out.println(mv.getMem_id() + "\t" + mv.getMem_name() + "\t" + mv.getMem_tel() + "\t" + mv.getMem_addr());
		}

		System.out.println("------------------------------------------");
		System.out.println("▶ 출력 작업 끝");
	}


	// 회원을 추가하는 메서드
	private void insertMenu() {

		boolean chk = false;

		String memId;

		do {
			System.out.println();
			System.out.println("▷ 추가할 회원 정보를 입력하세요.");
			System.out.print("▷ 회원 ID: ");
			memId = scan.next();
			chk = service.getMember(memId);	// 메서드 생성
			if(chk) {
				System.out.println("▷ 회원 ID가 \"" + memId + "\"인 회원은 이미 존재합니다.");
				System.out.println("▷ 다시 입력하세요.");
			}

		}while(chk);

		// 빠져나오면 insert 하는 부분이 생긴다.
		System.out.print("▷ 회원 이름: ");
		String memName = scan.next();

		System.out.print("▷ 회원 전화번호: ");
		String memTel = scan.next();

		scan.nextLine();	// 입력버퍼 지우기

		System.out.print("▷ 회원 주소: ");
		String memAddr = scan.next();

		
		MemberVO mv = new MemberVO();
		mv.setMem_id(memId);
		mv.setMem_name(memName);
		mv.setMem_tel(memTel);
		mv.setMem_addr(memAddr);
		
		// 여기에 담으려면 VO 객체로 저장을 해줘야 하기 전에 위처럼 VO에 담는 작업을 먼저 해준다.
		int cnt = service.insertMember(mv);

		if(cnt > 0) {
			System.out.println();
			System.out.println("▶ \"" + memId + "\" 회원 추가 작업 성공");
		}else {
			System.out.println();
			System.out.println("▶ \"" + memId + "\" 회원 추가 작업 실패");
		}

	}

	public static void main(String[] args) {
		MemberMain memObj = new MemberMain();
		memObj.start();
	}

}
























