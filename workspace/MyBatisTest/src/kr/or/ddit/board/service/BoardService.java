package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;

public class BoardService implements IBoardService{
	
	private IBoardDao boardDao;
	
	private static IBoardService boardService;
	
	private BoardService() {
		boardDao = BoardDao.getInstance();
	}

	public static IBoardService getInstance() {
		
		if(boardService == null) {
			boardService = new BoardService();
		}
		
		return boardService;
	}
	
	@Override
	public int insertBoard(BoardVO bv) {
		
		int cnt = boardDao.insertBoard(bv);
		
		if (cnt > 0) {
			
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int no) {
		
		int cnt = boardDao.deleteBoard(no);
		
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		
		int cnt = boardDao.updateBoard(bv);
		
		return cnt;
	}

	@Override
	public boolean checkBoard(int no) {
		
		boolean exist = boardDao.checkBoard(no);
		
		return exist;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		List<BoardVO> list = boardDao.searchBoard(bv);
		
		return list;
	}

	@Override
	public List<BoardVO> listBoard() {
		
		List<BoardVO> list = boardDao.listBoard();
		
		return list;
	}

}
