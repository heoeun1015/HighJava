package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.NoticeBoardDao;
import kr.or.ddit.dao.NoticeBoardDaoImpl;
import kr.or.ddit.vo.NoticeBoardVO;

public class NoticeBoardServiceImpl implements NoticeBoardService {
	
	private static NoticeBoardServiceImpl service;
	
	private NoticeBoardServiceImpl() {
		NBDao = NoticeBoardDaoImpl.getIntance();
	}
	
	public static NoticeBoardServiceImpl getInstatnce() {
		if(service == null) {
			service = new NoticeBoardServiceImpl();
		}
		return service;
	}
	
	private NoticeBoardDao NBDao;

	@Override
	public int insertMember(NoticeBoardVO nbo) {
		return NBDao.insertMember(nbo);
	}

	@Override
	public boolean getMember(String boardTitle) {
		return NBDao.getMember(boardTitle);
	}

	@Override
	public List<NoticeBoardVO> getAllMemberList() {
		return NBDao.getAllMemberList();
	}

	@Override
	public int modifyMember(NoticeBoardVO nbo) {
		return NBDao.modifyMember(nbo);
	}

	@Override
	public int deleteMember(String boardTitle) {
		return NBDao.deleteMember(boardTitle);
	}

	@Override
	public List<NoticeBoardVO> getSearchWrite(String boardTitle) {
		return NBDao.getSearchWrite(boardTitle);
	}

}
