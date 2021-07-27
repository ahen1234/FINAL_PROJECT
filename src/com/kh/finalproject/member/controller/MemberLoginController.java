package com.kh.finalproject.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kh.finalproject.member.dao.MemberDAO;
import com.kh.finalproject.pointmanagement.PointManagement;
import com.kh.finalproject.vo.MemberVO;

@WebServlet("/loginAction")
public class MemberLoginController extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		HttpSession session = null;
		MemberVO loginMember = null;
		
		String ID = req.getParameter("ID");
		String PW = req.getParameter("PW");
		
		MemberDAO DAO = new MemberDAO();
		PointManagement point = new PointManagement();
		String keyword = "login";
		int result;
		
		result =  DAO.UserLogin(ID,PW);
		
		if(result != 0){
			point.Pointmanagements(ID, keyword);
			loginMember = DAO.Userinformation(ID);
			session = req.getSession(true);
			session.setMaxInactiveInterval(60*60*2);
			session.setAttribute("loginMember", loginMember);
			out.println("<script>");
			out.println("alert('출석 10포인트 획득');");
			out.println("location.href = 'MainIndex.jsp';");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('아이디 혹은 비밀번호가 일치하지 않습니다.');");
			out.println("location.href = 'MainIndex.jsp';");
			out.println("</script>");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
