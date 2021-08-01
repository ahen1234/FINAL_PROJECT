package com.kh.finalproject.comment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.kh.finalproject.vo.CommentVO;

public class CommentDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
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
	
	
	
	public int CommentWrite(String id,String nickname, String comment, String post_code) {
		String sql = "INSERT INTO FINAL_COMMENT VALUES (?,?,?,?,?)";
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdate.format(date);
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post_code);
			pstmt.setString(2, id);
			pstmt.setString(3, nickname);
			pstmt.setString(4, comment);
			pstmt.setString(5, time);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	public ArrayList<CommentVO> commentlist(String post_code){
		String sql = "SELECT * FROM FINAL_COMMENT WHERE POST_CODE = ?";
		ArrayList<CommentVO> list = new ArrayList<>();
		CommentVO vo = null;
		
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post_code);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				vo = new CommentVO();
				vo.setID(rs.getString("ID"));
				vo.setNICKNAME(rs.getString("NICKNAME"));
				vo.setCOMMENTS(rs.getString("COMMENTS"));
				vo.setCOMMENT_DATE(rs.getString("COMMENT_DATE"));
				list.add(vo);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

}
