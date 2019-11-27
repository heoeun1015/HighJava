package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.NoticeBoardDaoImpl;
import kr.or.ddit.vo.NoticeBoardVO;

public class NoticeBoardServiceImpl implements NoticeBoardService {
	
	private NoticeBoardDaoImpl noticeDao;
	
	public NoticeBoardServiceImpl() {
		noticeDao = new NoticeBoardDaoImpl();
	}

	@Override
	public int insertMember(NoticeBoardVO nbo) {
		return noticeDao.insertMember(nbo);
	}

	@Override
	public boolean getMember(String boardTitle) {
		return noticeDao.getMember(boardTitle);
	}

	@Override
	public List<NoticeBoardVO> getAllMemberList() {
		return noticeDao.getAllMemberList();
	}

	@Override
	public int modifyMember(NoticeBoardVO nbo) {
		return noticeDao.modifyMember(nbo);
	}

	@Override
	public int deleteMember(String boardTitle) {
		return noticeDao.deleteMember(boardTitle);
	}

	@Override
	public List<NoticeBoardVO> getSearchWrite(String boardTitle) {
		return noticeDao.getSearchWrite(boardTitle);
	}

}
