package kr.or.ddit.main;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.service.NoticeBoardService;
import kr.or.ddit.service.NoticeBoardServiceImpl;
import kr.or.ddit.vo.NoticeBoardVO;

/*	위의 테이블을 작성하고 게시판을 관리하는
		다음 기능들을 구현하시오.
		
		기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 
		삭제, 검색 
		 
		------------------------------------------------------------
		
		게시판 테이블 구조 및 시퀀스
		
		create table jdbc_board(
		    board_no number not null,  -- 번호(자동증가)
		    board_title varchar2(100) not null, -- 제목
		    board_writer varchar2(50) not null, -- 작성자
		    board_date date not null,   -- 작성날짜
		    board_content clob,     -- 내용
		    constraint pk_jdbc_board primary key (board_no)
		);
		create sequence board_seq
		    start with 1   -- 시작번호
		    increment by 1; -- 증가값
				
		----------------------------------------------------------
		
		// 시퀀스의 다음 값 구하기
		//  시퀀스이름.nextVal		*/


public class T07_NoticeBoard {

	private NoticeBoardService service;

	private Scanner scan = new Scanner(System.in);
	
	public T07_NoticeBoard() {
		service = new NoticeBoardServiceImpl();
	}
	
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 새 글 작성");
		System.out.println("  2. 글 수정");
		System.out.println("  3. 글 삭제");
		System.out.println("  4. 글 검색");
		System.out.println("  5. 전체 목록 출력");
		System.out.println("  6. 끝내기");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	
	public static void main(String[] args) {
		
		new T07_NoticeBoard().start();
		
	}
	
	public void start(){
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = Integer.parseInt(scan.nextLine()); // 메뉴번호 입력받기
			switch(choice){
			case 1 :  // 새 글 작성
				newWrite();
				break;
			case 2 :  // 글 수정
				modifyWrite();
				break;
			case 3 :  // 글 삭제
				deleteWrite();
				break;
			case 4 :  // 글 검색
				searchWrite();
				break;
			case 5 :  // 전체 목록 출력
				displayWriteAll();
				break;
			case 6 :  // 끝내기
				System.out.println("▶ 작업을 마칩니다.");
				break;
			default :
				System.out.println("▶ 번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=6);
	}

	
	private void searchWrite() {
		
		boolean chk = false;

		System.out.print("▷ 검색할 글제목을 입력하세요.: ");
		String boardTitle = scan.nextLine();
		
		System.out.println("------------------------------------------");
		System.out.println(" NO.\t글쓴이\t글제목\t내용\t날짜");
		System.out.println("------------------------------------------");
		
		List<NoticeBoardVO> noticeList = service.getSearchWrite(boardTitle);
		
		for(NoticeBoardVO nbo : noticeList) {
			System.out.println(nbo.getBoard_no() + "\t" + nbo.getBoard_writer()+ "\t" + nbo.getBoard_title() + "\t" +
		nbo.getBoard_content() + "\t" + nbo.getBoard_date());
		}
		
		System.out.println("------------------------------------------");
		System.out.println("▶ 출력 작업 끝");

	}


	private void displayWriteAll() {
		
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println(" NO.\t글쓴이\t글제목\t내용\t날짜");
		System.out.println("---------------------------------------------------");

		List<NoticeBoardVO> noticeList = service.getAllMemberList();
		
		for(NoticeBoardVO nbo : noticeList) {
			System.out.println(nbo.getBoard_no() + "\t" + nbo.getBoard_writer()+ "\t" + nbo.getBoard_title() + "\t" +
		nbo.getBoard_content() + "\t" + nbo.getBoard_date());
		}
		
		System.out.println("---------------------------------------------------");
		System.out.println("▶ 출력 작업 끝");
	}


	private void deleteWrite() {
		
		System.out.println();
		System.out.print("▷ 삭제할 글 제목을 입력해주세요.: ");
		String boardTitle = scan.nextLine();
		
		int cnt = service.deleteMember(boardTitle);
		
		if(cnt > 0) {
			System.out.println();
			System.out.println("▶ \"" + boardTitle + "\" 제목의 글을 삭제했습니다.");
		}else {
			System.out.println();
			System.out.println("▶ \"" + boardTitle + "\" 제목의 글을 삭제하지 못했습니다");
		}
		
		
	}


	private void modifyWrite() {
		
		System.out.println();
		String boardNo = "";
		boolean chk = true;
		
		do {
			System.out.print("▷ 수정할 글 번호을 입력하세요.: ");
			boardNo = scan.nextLine();

			chk = service.getMember(boardNo);
			if(chk == false) {
				System.out.println("▷ \"" + boardNo + "\"번에 해당하는 글이 없습니다.");
				System.out.println(" 다시 입력해주세요.");
			}
		}while(chk == false);
		
		System.out.println();
		System.out.println("▷ 수정할 내용을 입력하세요.");
		System.out.print("▷ 수정할 글 제목: ");
		String boardTitle = scan.nextLine();
		
		System.out.print("▷ 수정할 아이디: ");
		String boardWriter = scan.nextLine();
		
		System.out.print("▷ 수정할 글 내용: ");
		String boardContent = scan.nextLine();
		
		NoticeBoardVO nbo = new NoticeBoardVO();
		nbo.setBoard_title(boardTitle);
		nbo.setBoard_writer(boardWriter);
		nbo.setBoard_content(boardContent);
		nbo.setBoard_no(boardNo);
		
		int cnt = service.modifyMember(nbo);
		
		if(cnt > 0) {	
			System.out.println();
			System.out.println("▶ \"" + boardNo + "\"번 글을 수정했습니다.");
		}else {
			System.out.println();
			System.out.println("▶ \"" + boardNo + "\"번 글을 수정하는데 실패했습니다.");
		}
		
	}


	private void newWrite() {
		
		boolean chk = false;

		String title;
		String writer;
		String content;
		
		System.out.println();
		System.out.print("▷ 본인의 아이디를 적어주세요.: ");
		writer = scan.nextLine();
		
		System.out.print("▷ 글 제목을 작성해주세요.: ");
		title = scan.nextLine();
		
		System.out.print("▷ 글 내용을 작성해주세요.: ");
		content = scan.nextLine();
		
		NoticeBoardVO nbo = new NoticeBoardVO();
		nbo.setBoard_title(title);
		nbo.setBoard_writer(writer);
		nbo.setBoard_content(content);
		
		int cnt = service.insertMember(nbo);
		
		if(cnt > 0) {
			System.out.println();
			System.out.println("▶ 글 작성 완료");
		}else {
			System.out.println();
			System.out.println("▶ 글 작성 실패");
		}
		
		
	}
	
	
	
}



