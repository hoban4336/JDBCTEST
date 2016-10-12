package com.bit2016.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 로딩. (oracle)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 상용 버전은 xe -> orcl
			conn = DriverManager.getConnection(url, "bitdb", "bitdb");

			//3. Statement 준비
			//String sql =" update book set title = ?, state = ?where no = ?";
			String sql ="insert into book values(?,?,sysdate,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//4.값 바인딩
			Long no =15L;
			String title = "토지15";
			String state = "대여중";
			Long Author_no = 1L;
			
			pstmt.setString(1, title);
			pstmt.setString(2, state);
			pstmt.setLong(3, no);
			
			int count = pstmt.executeUpdate();
			System.out.println(count);
			
			
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
