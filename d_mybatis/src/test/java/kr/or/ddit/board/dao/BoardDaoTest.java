package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class BoardDaoTest {

	@Test
	public void selectBoardtest() {
		
		// Junit 테스트 코드 성공 실패
		// 성공: @Test 어노테이션이 붙은 메소드를 실행할 때
		//		예외, 에러 발생 없이 정상적으로 실행될 때 성공
		//		Assert 관련 메소드가 전부 true로 판정될 때 성공
		
		IBoardDao boardDao = new BoardDao();
		List<Map<String, String>> boardList = boardDao.selectBoard();
		
		// boardList가 3개면 성공, 아니면 실패
		assertEquals(3, boardList.size());
		
		if(boardList.size() == 3) {
			System.out.println("▷ 성공");
			System.out.println(boardList);
		}
		else
			System.out.println("▷ 실패");
	}
	
	@Test
	public void selsetBoardByUseTest() {
		IBoardDao boardDao = new BoardDao();
		List<Map<String, String>> boardList = boardDao.selectBoardByUse("Y");
		
		assertEquals(3, boardList.size());
		
	}

}
