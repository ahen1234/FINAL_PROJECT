package com.kh.finalproject.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
				Boardlist.add(vo);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		
		return Boardlist;
		
	}

	public BoardVO boardread(String title, String id) {
		String sql = "SELECT * FROM FINAL_BOARD WHERE TITLE = ? AND ID = ?";
		String sql2 = "UPDATE FINAL_BOARD SET VIEWS_CUT = VIEWS_CUT + 1 WHERE TITLE = ? AND ID = ?";
		BoardVO vo = null;
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, id);
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
			}
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, title);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		
		return vo;
	}

	

}
