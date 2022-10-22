package kr.or.ddit.basic.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import kr.or.ddit.util.JDBCUtil;
import kr.or.ddit.util.JDBCUtil2;

/*
create table hotel(
room number,
name varchar2(20),
constraint pk_hotel primary key(room))
 */

public class Hotel {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner scanner = new Scanner(System.in);
	
	public Hotel() {
		super();
	}
	
	public void start() {
		// 실행 처음 보이는 화면
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		System.out.println();
	}
	
	public void menu() {
		while (true) {
			System.out.println("");
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************************");
			System.out.println("");
			System.out.print("메뉴선택 => ");
			int choice = scanner.nextInt();
			System.out.println("");
			
			switch (choice) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				config();
				break;
			case 4:
				System.out.println("**************************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("**************************");
				return;
			}
		}
	}
	
	public void checkIn() {
		
		boolean exist = false;
		
		int roomNum = 0;
		
		do {
			System.out.println("어느 방에 체크인 하시겠습니까?");
			System.out.print("방 번호 입력 => ");
			
			roomNum = scanner.nextInt();
			
			exist = checkedIn(roomNum);
			
			if(exist) {
				System.out.println("해당 방 " + roomNum +"은 예약된 방입니다.");
				System.out.println("다시 입력해주세요.");
			}
			
		} while (exist);
		
		scanner.nextLine();
		System.out.println();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		String name = scanner.nextLine();
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = " insert into hotel (ROOM, NAME) "
					   + " values(?, ? )";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNum);
			pstmt.setString(2, name);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println(roomNum + " 체크인 성공");
			} else {
				System.out.println(roomNum + " 체크인 실패!!");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
			System.out.println("체크인 되었습니다.");
		}
	}
	
	public boolean checkedIn(int roomNum) {
		boolean exist = false;

		try {
			conn = JDBCUtil2.getConnection();

			String sql = "select count(*) as cnt " + " from hotel " + " where room = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNum);

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
			JDBCUtil2.close(conn, stmt, pstmt, rs);
		}

		return exist;
	}
	
	public void checkOut() {
		System.out.println("어느 방을 체크아웃 하시겠습니까?");
		System.out.print("방 번호 입력 => ");
		int roomNum = scanner.nextInt();
		scanner.nextLine();
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = " delete from hotel where room = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNum);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println(roomNum + " 체크아웃 성공");
			} else {
				System.out.println(roomNum + " 체크아웃 실패!!");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
			System.out.println("체크아웃 되었습니다.");
		}
	}
	
	public void config() {
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "select * from hotel";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int roomNum = rs.getInt("room");
				String name = rs.getString("name");
				System.out.printf("방 번호 : %d, 투수객 : %s\n", roomNum, name);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}
	
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		hotel.start();
		hotel.menu();
		
	}
}