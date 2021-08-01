package com.kh.finalproject.board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import com.kh.finalproject.vo.BoardVO;

public class BoardDAO {
	
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
	

	
	
	public ArrayList<BoardVO> boardlists(String write) {
		String sql = "SELECT * FROM FINAL_BOARD WHERE BOARD_TYPE = ?";
		ArrayList<BoardVO> Boardlist = new ArrayList<>();
		try {
			
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, write);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setID(rs.getString("ID"));
				vo.setNICKNAME(rs.getString("NICKNAME"));
				vo.setTITLE(rs.getString("TITLE"));
				vo.setCONTENTS(rs.getString("CONTENTS"));
				vo.setVIEWS_CUT(rs.getInt("VIEWS_CUT"));
				vo.setRECOMMEND_CUT(rs.getInt("RECOMMEND_CUT"));
				vo.setREPORT(rs.getInt("REPORT"));
				vo.setREPORTING_DATE(rs.getString("REPORTING_DATE"));
				vo.setPOST_CODE(rs.getString("POST_CODE"));
				Boardlist.add(vo);
			}	
			
			if (rs != null){rs.close();}
			if (pstmt != null){pstmt.close();}
			if (conn != null){conn.close();}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return Boardlist;
		
	}

	public BoardVO boardread(String post_code) {
		String sql = "SELECT * FROM FINAL_BOARD WHERE POST_CODE = ?";
		String sql2 = "UPDATE FINAL_BOARD SET VIEWS_CUT = VIEWS_CUT + 1 WHERE POST_CODE = ?";
		BoardVO vo = null;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post_code);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vo = new BoardVO();
				vo.setID(rs.getString("ID"));
				vo.setNICKNAME(rs.getString("NICKNAME"));
				vo.setTITLE(rs.getString("TITLE"));
				vo.setCONTENTS(rs.getString("CONTENTS"));
				vo.setREPORTING_DATE(rs.getString("REPORTING_DATE"));
				vo.setVIEWS_CUT(rs.getInt("VIEWS_CUT"));
				vo.setRECOMMEND_CUT(rs.getInt("RECOMMEND_CUT"));
				vo.setREPORT(rs.getInt("REPORT"));
				vo.setPOST_CODE(rs.getString("POST_CODE"));
			}
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, post_code);
			pstmt.executeUpdate();
			
			if (rs != null){rs.close();}
			if (pstmt != null){pstmt.close();}
			if (conn != null){conn.close();}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public String randomCode(){
		Random rnd = new Random(); 
		char[] array = new char[20]; 
		String code = "";
		for( int i = 0; i < array.length; i++) { 
			array[i] = (char) ((rnd.nextInt(26) + 65)); 
		} 
		
		code = String.valueOf(array);
		
		return code;
	}

	public boolean boardwrite(String id, String nickname, String title, String contents, String board) {
		String sql1 = "SELECT POST_CODE FROM FINAL_BOARD";
		String sql2 = "INSERT INTO FINAL_BOARD VALUES (?,?,?,?,?,?,?,?,?,?)";
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdate.format(date);
		
		try {
			
			String POST_CODE = "";
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			POST_CODE = this.randomCode();
			while(rs.next()) {
				if(rs.getString("POST_CODE") == POST_CODE){
					POST_CODE = this.randomCode();
				}
			}
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, board);
			pstmt.setString(2, id);
			pstmt.setString(3, nickname);
			pstmt.setString(4, title);
			pstmt.setString(5, contents);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			pstmt.setString(9, time);
			pstmt.setString(10, POST_CODE);
			pstmt.executeUpdate();
			
			if (rs != null){rs.close();}
			if (pstmt != null){pstmt.close();}
			if (conn != null){conn.close();}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	

}
