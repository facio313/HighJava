package kr.or.ddit.basic.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.basic.homework.BoardVO;
import kr.or.ddit.util.JDBCUtil3;

/*
위의 테이블을 작성하고 게시판을 관리하는
다음 기능들을 구현하시오.

기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
 
*/

public class Board {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in);
	
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 새 글 작성");
		System.out.println("  2. 글 삭제");
		System.out.println("  3. 글 수정");
		System.out.println("  4. 글 검색");
		System.out.println("  5. 전체 목록 출력");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");	
	}
	
	public void start() {
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 새 글 작성
				insertBoard();
				break;
			case 2: // 글 삭제
				deleteBoard();
				break;
			case 3: // 글 수정
				updateBoard();
				break;
			case 4: // 글 검색
				searchBoard();
				break;
			case 5: // 전체 목록 출력
				listBoard();
				break;
			case 6: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}

	public void insertBoard() {
		
		System.out.println();
		
		System.out.println();
		System.out.print("제목 >> ");
		String title = scan.next();
		
		System.out.println();
		System.out.print("글쓴이 >> ");
		String writer = scan.next();
		
		scan.nextLine();
		
		System.out.println();
		System.out.print("내용 >> ");
		String content = scan.nextLine();
		
		try {

			conn = JDBCUtil3.getConnection();

			String sql =" insert into JDBC_BOARD "
					+ " (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CONTENT) "
					+ " values (board_seq.nextval, ?, ?, sysdate, ?)" ;

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("\"" + title + "\" 새 글 작성 성공");
			} else {
				System.out.println("\"" + title + "\" 새 글 작성 실패!!");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

	}
	
	public void deleteBoard() {
		System.out.println();
		System.out.println("삭제할 글 번호를 입력하세요.");
		System.out.print("번호 >> ");
		
		int no = scan.nextInt();
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = " delete from JDBC_BOARD where BOARD_NO = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println(no + "번 글 삭제 성공");
			} else {
				System.out.println(no + "번 글 삭제 실패");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
	}
	
	public void updateBoard() {
		boolean exist = false;
		
		int no = 0;
		
		do {
			System.out.println();
			System.out.println("수정할 글 번호를 입력하세요.");
			System.out.print("번호 >> ");
		
			no = scan.nextInt();
			
			exist = checkBoard(no);
			
			if(!exist) {
				System.out.println(no + "번 글이 존재하지 않습니다.");
				System.out.println("다시 입력해주세요.");
			}
		} while (!exist);
		
		System.out.println();
		System.out.print("제목 >> ");
		String title = scan.next();
		
		System.out.println();
		System.out.print("글쓴이 >> ");
		String writer = scan.next();
		
		scan.nextLine();
		
		System.out.println();
		System.out.print("내용 >> ");
		String content = scan.nextLine();
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = " update JDBC_BOARD "
					+ " set BOARD_TITLE = ?, "
				    + " BOARD_WRITER = ?, "
				    + " BOARD_CONTENT = ? "
				    + " where BOARD_NO = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			pstmt.setInt(4, no);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) { // 안 뜰 때는 커밋이 안 돼있는 것!
				System.out.println(no + "번 글 수정 성공");
			} else {
				System.out.println(no + "번 글 수정 실패!!");
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		
	}

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
	
	public void searchBoard() {
		scan.nextLine();
		
		System.out.println();
		System.out.println("검색할 글 정보를 입력하세요.");
		
		System.out.print("글 번호 >> ");
		int no = scan.nextInt();
		
		System.out.print("책 제목 >> ");
		String title = scan.nextLine().trim();
		
		System.out.print("작가 >> ");
		String writer = scan.nextLine().trim();
		
		BoardVO bv = new BoardVO();
		bv.setNo(no);
		bv.setTitle(title);
		bv.setWriter(writer);
		
		List<BoardVO> list = new ArrayList<>();
		
		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = " select * from JDBC_BOARD where 1=1 ";
			
			if (bv.getNo() <= 0) {
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
			
			if (bv.getNo() <= 0) {
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
				
				list.add(bv2);
				
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("번호\t제목\t글쓴이\t날짜\t내용");
		System.out.println("-------------------------------------------------------------");
		
		if (list.size() == 0) {
			System.out.println("글 정보가 존재하지 않습니다.");
		} else {
			
			for (BoardVO bv2 : list) {
				System.out.println(
						bv2.getNo() 	+ "\t" 
								+ bv2.getTitle() 	+ "\t" 
								+ bv2.getWriter() 	+ "\t" 
								+ bv2.getDate() 	+ "\t" 
								+ bv2.getContent() 	+ "\t");
			}
			
		}
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("검색 작업 끝.");
	}
	
	public void listBoard() { // 리스트 타입으로 바꾸기
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println("번호\t제목\t글쓴이\t날짜\t내용");
		System.out.println("-------------------------------------------------------------");
		
		try {
			
			conn = JDBCUtil3.getConnection();
			
			String sql = "select * from JDBC_BOARD";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int no = rs.getInt("BOARD_NO");
				String title = rs.getString("BOARD_TITLE");
				String writer = rs.getString("BOARD_WRITER");
				Date date = rs.getDate("BOARD_DATE");
				String content = rs.getString("BOARD_CONTENT");
				
				System.out.println(no + "\t"
								+ title + "\t"
								+ writer + "\t"
								+ date + "\t"
								+ content + "\t");
			}
			System.out.println("-------------------------------------------------------------");
			System.out.println("출력 작업 끝.");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
	}
	
	public static void main(String[] args) {
		Board board = new Board();
		board.start();
	}
}
