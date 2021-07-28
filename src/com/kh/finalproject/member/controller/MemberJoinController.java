package com.kh.finalproject.member.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.finalproject.member.dao.MemberDAO;

@WebServlet("/UserJoin")
public class MemberJoinController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String ID = req.getParameter("ID");
		String PW = req.getParameter("PW");
		String NICKNAME = req.getParameter("NICKNAME");
		String MAIL = req.getParameter("MAIL");
		
		
		MemberDAO DAO = new MemberDAO();
		
		int result = DAO.MemberJoin(ID,PW,NICKNAME,MAIL);
		
		if(result == 1){
			resp.sendRedirect("MainIndex.jsp");
		} else {
			resp.sendRedirect("Error.jsp");
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
