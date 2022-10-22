package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDao {

	public int insertBoard(BoardVO bv);
	public int deleteBoard(int no);
	public int updateBoard(BoardVO bv);
	public boolean checkBoard(int no);
	public List<BoardVO> searchBoard(BoardVO bv);
	public List<BoardVO> listBoard();
	
}
