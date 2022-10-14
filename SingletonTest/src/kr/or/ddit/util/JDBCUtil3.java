package kr.or.ddit.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * db.properties파일의 내용으로 DB접속정보를 설정하는 방법
 * 방법2) ResourceBundle객체 이용하기
 */
public class JDBCUtil3 {

	static ResourceBundle bundle; // ResourceBundle 객체변수 선언
	
	static {
		
		bundle = ResourceBundle.getBundle("db");
		
		try {
		
			
			// 0. 드라이버 로딩(리플렉션 기법 사용)
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!!");
			e.printStackTrace();
		}
	}
	// 1. DB 접속 - 하드코딩한 것을 수정할 때마다 번거로운 작업이 많음. 유지보수가 좋지 않음
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					bundle.getString("url"), 
					bundle.getString("username"), 
					bundle.getString("password"));
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	// 5. 자원 반납
	public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) try {rs.close();} catch (SQLException ex) {}
		if (stmt != null) try {stmt.close();} catch (SQLException ex) {}
		if (pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
		if (conn != null) try {conn.close();} catch (SQLException ex) {}
	}
}
