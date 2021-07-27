package com.kh.finalproject.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.finalproject.board.dao.BoardDAO;
import com.kh.finalproject.vo.BoardVO;

@WebServlet("/boardread")
public class BoardReadController extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String title = req.getParameter("title");
		String id = req.getParameter("id");
		
		BoardDAO DAO = new BoardDAO();
		BoardVO VO = new BoardVO();
		RequestDispatcher dispatcher = null;
		
		VO = DAO.boardread(title,id);
		
		if(VO != null){
			req.setAttribute("boardread", VO);
			dispatcher = req.getRequestDispatcher("/Post_View.jsp");
			
		} else {
			dispatcher = req.getRequestDispatcher("/Error.jsp");
		}
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
