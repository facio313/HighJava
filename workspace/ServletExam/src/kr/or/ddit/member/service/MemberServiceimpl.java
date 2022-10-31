package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceimpl implements IMemberService{

	private IMemberDao memDao;
	
	private static IMemberService memService;
	
	private MemberServiceimpl() {
		memDao = MemberDaoImpl.getInstance(); // --> static이기 때문에 클래스.메서드()하는 것
	}
	
	public static IMemberService getInstance() {
		
		if(memService == null) { // null이라는 건 아직 한 번도 객체가 생성되지 않음
			memService = new MemberServiceimpl();
		}
		
		return memService;
	}
	
	
	@Override
	public int registMember(MemberVO mv) {
		
		int cnt = memDao.insertMember(mv);
		
		if (cnt > 0) {
			//메일 발송 기능 호출...
		}
		
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		
		boolean exist = memDao.checkMember(memId);
		
		return exist;
	}

	@Override
	public int modifyMember(MemberVO mv) {
		
		int cnt = memDao.updateMember(mv);
		
		return cnt;
	}

	@Override
	public int removeMember(String memId) {
		
		int cnt = memDao.deleteMember(memId);
		
		return cnt;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		
		List<MemberVO> memList = memDao.selectAllMember();
		
		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		
		List<MemberVO> memList = memDao.searchMember(mv);
		
		return memList;
	}

	@Override
	public MemberVO getMember(String memId) {
		
		return memDao.getMember(memId);
	}

}
