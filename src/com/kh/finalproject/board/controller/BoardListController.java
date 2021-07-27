package com.kh.finalproject.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.finalproject.board.dao.BoardDAO;
import com.kh.finalproject.vo.BoardVO;
@WebServlet("/Noticelist")
public class BoardListController extends HttpServlet {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		RequestDispatcher dispatcher = null;
		
		String write = req.getParameter("write");
		
		ArrayList<BoardVO> boardlist = new ArrayList<>();
		BoardDAO DAO = new BoardDAO();
		
		boardlist = DAO.boardlists(write);
		
		if(boardlist.size() != 0){
			req.setAttribute("boardlist", boardlist);
			dispatcher = req.getRequestDispatcher("Board_View.jsp");
		} 
		
		dispatcher.forward(req, resp);
		
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
