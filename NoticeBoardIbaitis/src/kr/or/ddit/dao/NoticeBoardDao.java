package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.NoticeBoardVO;

public interface NoticeBoardDao {

	public int insertMember(NoticeBoardVO nbo);
	
	public boolean getMember(String boardTitle);
	
	public List<NoticeBoardVO> getAllMemberList();
	
	public int modifyMember(NoticeBoardVO nbo);
	
	public int deleteMember(String boardTitle);
	
	public List<NoticeBoardVO> getSearchWrite(String boardTitle);
}
