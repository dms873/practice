package kh.test.first.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTemplate {

	private static Connection conn = null;

	public static Connection getConnection() {
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";
			String password = "SCOTT";
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// 로딩 실패 시
			System.out.println("ojdbc 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// 접속 실패 시
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		} catch (Exception e) {
			// 제일 큰 예외처리(Exception)도 설정
			System.out.println("Unknown 오류");
			e.printStackTrace();
		}
		
		if(conn == null) 
			System.out.println("conn이 null 상태 입니다.");
		else 
			System.out.println("======= DB 접속 성공 =======");

		return conn;
	}

	// try ~ catch를 많이 쓰기 때문에 따로 함수를 만들어준다.
	// conn 객체 닫기
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// stmt 객체 닫기
	// pstmt는 stmt의 후손이므로 굳이 close를 생성하지 않아도 됨
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// rset 객체 닫기
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed())
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// AutoCommit on/off(connection에 걸어준다!)
	public static void setAutoCommit(Connection conn, boolean onoff) {
		try {
			if(conn != null && !conn.isClosed())
				conn.setAutoCommit(onoff);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// commit 하는 함수(connection에 걸어준다!)
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// rollback 하는 함수(connection에 걸어준다!)
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
