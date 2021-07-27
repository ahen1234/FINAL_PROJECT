package com.kh.finalproject.pointmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PointManagement {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//DB연결
	private Connection getConnection() { 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "TH"; 
			String db_pw = "tmakdlf1"; 
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
			
			
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//DB 일괄 닫기
	private void close(Connection conn, PreparedStatement pstmt,ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//포인트 더하기
	public void Pointmanagements(String ID,String keyword){
		String sql1 = "UPDATE FINAL_USER SET POINT = POINT + 5 WHERE ID =? ";
		String sql2 = "UPDATE FINAL_USER SET POINT = POINT + 10 WHERE ID =? ";
		String sql3 = "UPDATE FINAL_USER SET POINT = POINT + 5 WHERE ID =? ";
		try {
			conn = this.getConnection();
			
			if(keyword == "login"){
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, ID);
				pstmt.executeUpdate();
			} else if (keyword == "write"){
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, ID);
				pstmt.executeUpdate();
			} else if(keyword == "comment") {
				pstmt = conn.prepareStatement(sql3);
				pstmt.setString(1, ID);
				pstmt.executeUpdate();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		
		
		
	}
	
	
}
