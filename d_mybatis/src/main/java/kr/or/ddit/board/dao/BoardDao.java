package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.db.MybatisUtil;

public class BoardDao implements IBoardDao{

	public List<Map<String, String>> selectBoard() {
		// mybatis sql 실행시 필요한 객체: sqlSession
			// mybatisUtil에 다 있다.
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		// 여러건의 실행결과가 나오는 sql: selectList
		// 1건의 실행결과가 나오는 sql: selectOne
		// dml: insert, updat, delete
		List<Map<String, String>> boardList = sqlSession.selectList("board.selectBoard");	// 실행해줄 쿼리 이름만 적어준다.
		
		// sql Session 객체를 사용했으면 닫아줘야 한다.
		
		sqlSession.close();
		
		return boardList;
	}

	public List<Map<String, String>> selectBoardByUse(String useYn) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<Map<String, String>> boardList = sqlSession.selectList("board.selectBoardByUse", useYn);
		
		sqlSession.close();
		
		return boardList;
	}
	
	
	
}
