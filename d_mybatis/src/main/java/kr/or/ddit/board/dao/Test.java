package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		
		// service
		IBoardDao boardDao = new BoardDao();
		List<Map<String, String>> boardList = boardDao.selectBoard();
		
		if(boardList.size() == 3) {
			System.out.println("▷ 성공");
			System.out.println(boardList);
		}
		else
			System.out.println("▷ 실패");
		
	}
}
