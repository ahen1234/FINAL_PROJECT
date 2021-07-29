package com.kh.finalproject.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.kh.finalproject.vo.MemberVO;

public class MemberDAO {
	
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
	
	
	
	public int MemberJoin(String ID, String PW, String NICKNAME, String MAIL) {
		String sql = "INSERT INTO FINAL_USER VALUES (?,?,?,?,?,?,?)";
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdate = new SimpleDateFormat("YYYY-MM-DD");
		String time = sdate.format(date);
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			pstmt.setString(2, PW);
			pstmt.setString(3, NICKNAME);
			pstmt.setString(4, MAIL);
			pstmt.setInt(5, 0);
			pstmt.setString(6, "회원");
			pstmt.setString(7, time);
			pstmt.executeUpdate();
			
			conn.commit();
			
			if (pstmt != null){pstmt.close();}
			if (conn != null){conn.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public int UserLogin(String ID, String PW) {
		try {
			
			String sql = "SELECT * FROM FINAL_USER WHERE ID = ?";
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("PW").equals(PW)) {
					return 1;
				} 
			}
			
			if (rs != null){rs.close();}
			if (pstmt != null){pstmt.close();}
			if (conn != null){conn.close();}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return 0;
	}

	public MemberVO Userinformation(String ID) {
		MemberVO vo = null;
		try {
			conn = this.getConnection();
			String sql = "SELECT * FROM FINAL_USER WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("ID"));
				vo.setPw(rs.getString("PW"));
				vo.setNickname(rs.getString("NICKNAME"));
				vo.setMail(rs.getString("MAIL"));
				vo.setPoint(rs.getInt("POINT"));
				vo.setGrade(rs.getString("GRADE"));
				vo.setJoindate(rs.getString("JOINDATE"));
			}
			if (rs != null){rs.close();}
			if (pstmt != null){pstmt.close();}
			if (conn != null){conn.close();}
		} catch (Exception e) {
			System.out.println("유저데이터 불러오기 오류");
			e.printStackTrace();
		} 
		
		return vo;
	}
	
	

}
