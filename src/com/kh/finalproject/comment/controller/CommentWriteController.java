package com.kh.finalproject.comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.finalproject.comment.dao.CommentDAO;
@WebServlet("/Commentwrite")
public class CommentWriteController extends HttpServlet {
		
	
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
		String comment = req.getParameter("comment");
		String post_code = req.getParameter("post_code");
		
		
		CommentDAO DAO = new CommentDAO();
		RequestDispatcher dispatcher = null;
		
		int result = DAO.CommentWrite(id,nickname,comment,post_code);
		
		
		if(result == 1 ){
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
