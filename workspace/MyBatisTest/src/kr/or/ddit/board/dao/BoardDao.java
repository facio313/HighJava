package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.MyBatisDao;
import kr.or.ddit.board.vo.BoardVO;

public class BoardDao extends MyBatisDao implements IBoardDao {

	private static IBoardDao boardDao;
	
	private BoardDao() {
		
	}
	
	public static IBoardDao getInstance() {
		if (boardDao == null) {
			boardDao = new BoardDao();
		}
		
		return boardDao;
	}
	
	@Override
	public int insertBoard(BoardVO bv) {

		return insert("board.insertBoard", bv);
	}

	@Override
	public int deleteBoard(int no) {
		
		return delete("board.deleteBoard", no);
	}

	@Override
	public int updateBoard(BoardVO bv) {
		
		return update("board.updateBoard", bv);
	}

	@Override
	public boolean checkBoard(int no) {
		
		boolean exist = false;
		
		int cnt = (int) selectOne("board.checkBoard", no);
		
		if (cnt > 0) {
			exist = true;
		}

		return exist;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		return selectList("board.searchBoard", bv);
	}

	@Override
	public List<BoardVO> listBoard() {
		
		return selectList("board.listBoard", null);
	}

}
