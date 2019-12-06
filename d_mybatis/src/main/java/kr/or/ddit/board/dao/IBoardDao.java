package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

public interface IBoardDao {

	// 게시판 전체 리스트 조회
		// 개발할 때 SQL 아이디랑 동일하게 하는게 좋다. 귀찮다고 그냥 가면 다른 사람한테 피해끼치는 거..
	List<Map<String, String>> selectBoard();
	
	// 사용여부에 따른 게시판 조회
	List<Map<String, String>> selectBoardByUse(String useYn);
	
}
