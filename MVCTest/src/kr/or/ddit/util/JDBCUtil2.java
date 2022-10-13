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

/**
 * db.properties파일의 내용으로 DB접속정보를 설정하는 방법
 * 방법1) Properties객체 이용하기
 */
public class JDBCUtil2 {

	static Properties prop; // Properties객체변수 선언
	
	// 한 번만 실행할 거 넣으면 됨(Class.forName())
	static {
		
		prop = new Properties();
		
		try {
			
			prop.load(new FileInputStream("res/db.properties"));
			
			// 0. 드라이버 로딩(리플렉션 기법 사용)
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 1. DB 접속 - 하드코딩한 것을 수정할 때마다 번거로운 작업이 많음. 유지보수가 좋지 않음
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					prop.getProperty("url"), 
					prop.getProperty("username"), 
					prop.getProperty("password"));
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
