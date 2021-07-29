package com.kh.finalproject.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.finalproject.board.dao.BoardDAO;

@WebServlet("/BoardWrite")
public class BoardWriteController extends HttpServlet {
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String id = req.getParameter("id");
		String nickname = req.getParameter("nickname");
		String title = req.getParameter("TITLE");
		String contents = req.getParameter("CONTENTS");
		String board = req.getParameter("BOARD");
		
		BoardDAO DAO = new BoardDAO();
		
		boolean result =  DAO.boardwrite(id,nickname,title,contents,board);
		
		if(result == true){
			resp.sendRedirect("/Noticelist?write=" + board);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
