package com.bit2016.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDao {

	public void insert(AuthorVo vo){
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
			String sql ="insert into Author values(?,?)";
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			
			int count = pstmt.executeUpdate();
			System.out.println("Author dao inserted : "+count);
			
		
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
