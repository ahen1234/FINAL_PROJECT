package com.kh.finalproject.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.finalproject.admin.dao.AdminDAO;
import com.kh.finalproject.vo.MemberVO;
@WebServlet("/UserList")
public class UserListController extends HttpServlet{
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String Memberlist = req.getParameter("Memberlist");
		
		ArrayList<MemberVO> memberlist = new ArrayList<>();
		RequestDispatcher dispatcher = null;
		AdminDAO DAO = new AdminDAO();
		
		memberlist = DAO.Memberlist(Memberlist);
		
		if(memberlist.size() != 0){
			req.setAttribute("Memberlist", memberlist);
			dispatcher = req.getRequestDispatcher("Admin_view.jsp");
		} else {
			resp.sendRedirect("Error.jsp");
		}
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
