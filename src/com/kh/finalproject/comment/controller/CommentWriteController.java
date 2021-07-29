package com.kh.finalproject.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.finalproject.comment.dao.CommentDAO;
@WebServlet("/Commentwrite")
public class CommentWriteController extends HttpServlet {
		
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String id = req.getParameter("id");
		String comment = req.getParameter("comment");
		String post_code = req.getParameter("post_code");
		
		CommentDAO DAO = new CommentDAO();
		
		DAO.CommentWrite(id,comment,post_code);
		
		

		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
