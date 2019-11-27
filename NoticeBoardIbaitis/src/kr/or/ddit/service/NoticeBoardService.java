package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.NoticeBoardVO;

public interface NoticeBoardService {
	
	public int insertMember(NoticeBoardVO nbo);
	
	public boolean getMember(String boardTitle);
	
	public List<NoticeBoardVO> getAllMemberList();
	
	public int modifyMember(NoticeBoardVO nbo);
	
	public int deleteMember(String boardTitle);
	
	public List<NoticeBoardVO> getSearchWrite(String boardTitle);

}
