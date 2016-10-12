package com.bit2016.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
	
	public static void main(String[] args) {
		Connection conn =null; 
		Statement stmt =null;
		ResultSet rs = null;
		try {
			//1. JDBC 드라이버 로딩. (oracle)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; 							// 상용 버전은 xe -> orcl
			 conn = DriverManager.getConnection(url,"bitdb","bitdb");
			 
			 stmt = conn.createStatement();
			 Long no =13L;
			 String title = "토지13";
			 String date = "2016-10-10";
			 String state = "대여가능";
			 Long authorNo = 1L;
			 
			 String sql = "insert into book values("+no+",	 '"+title+"'	,	"+date+"	,	"+authorNo+"	,	'"+state+"')";
					 
			int count =  stmt.executeUpdate(sql);
			System.out.println(count);
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("error"+ e);
		} finally{
			try { if(rs !=null)rs.close();} catch (SQLException e) {e.printStackTrace();}
			try { if(stmt !=null)stmt.close();} catch (SQLException e) {e.printStackTrace();}
			try { if(conn !=null)conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
}
