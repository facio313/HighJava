package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.JDBCUtil3;

public class BoardDao implements IBoardDao {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int insertBoard(BoardVO bv) {

		int cnt = 0;

		try {

			conn = JDBCUtil3.getConnection();

			String sql = " insert into JDBC_BOARD "
					+ " (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CONTENT) "
					+ " values (board_seq.nextval, ?, ?, sysdate, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getTitle());
			pstmt.setString(2, bv.getWriter());
			pstmt.setString(3, bv.getContent());

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int no) {
		
		int cnt = 0;
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = " delete from JDBC_BOARD where BOARD_NO = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		
		int cnt = 0;
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = " update JDBC_BOARD "
					+ " set board_title = ?, "
					+ " board_writer = ?, "
					+ " board_content = ? "
					+ " where board_no = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getTitle());
			pstmt.setString(2, bv.getWriter());
			pstmt.setString(3, bv.getContent());
			pstmt.setInt(4, bv.getNo());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public boolean checkBoard(int no) {
		
		boolean exist = false;
		
		try {
			conn = JDBCUtil3.getConnection();

			String sql = "select count(*) as cnt " + " from JDBC_BOARD " + " where BOARD_NO = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			int cnt = 0;

			while (rs.next()) {
				cnt = rs.getInt("cnt");
			}

			if (cnt > 0) {
				exist = true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return exist;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		List<BoardVO> list = new ArrayList<>();
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = " select * from JDBC_BOARD where 1=1 ";
			
			if (bv.getNo() > 0) {
				sql += " and board_no = ? ";
			}
			
			if (bv.getTitle() != null && !bv.getTitle().equals("")) {
				sql += " and board_title = ?";
			}
			if (bv.getWriter() != null && !bv.getWriter().equals("")) {
				sql += " and board_writer = ?";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			int index = 1;
			
			if (bv.getNo() > 0) {
				pstmt.setInt(index++,  bv.getNo());
			}
			
			if (bv.getTitle() != null && !bv.getTitle().equals("")) {
				pstmt.setString(index++, bv.getTitle());
			}
			if (bv.getWriter() != null && !bv.getWriter().equals("")) {
				pstmt.setString(index++, bv.getWriter());
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				BoardVO bv2 = new BoardVO();
				
				bv2.setNo(rs.getInt("board_no"));
				bv2.setTitle(rs.getString("board_title"));
				bv2.setWriter(rs.getString("board_writer"));
				bv2.setDate(rs.getDate("board_date"));
				bv2.setContent(rs.getString("board_content"));
				
				list.add(bv2);
				
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<BoardVO> listBoard() {
		
		List<BoardVO> list = new ArrayList<>();
		
		try {
			
			conn = JDBCUtil3.getConnection();
			
			String sql = "select * from JDBC_BOARD";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				BoardVO bv = new BoardVO();
				
				bv.setNo(rs.getInt("board_no"));
				bv.setTitle(rs.getString("board_title"));
				bv.setWriter(rs.getString("board_title"));
				bv.setDate(rs.getDate("board_date"));
				bv.setContent(rs.getString("board_content"));
				
				list.add(bv);
			}
				
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return list;
	}

}
