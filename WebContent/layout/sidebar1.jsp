<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/CSS/Final_Project.css">

	<form action="/loginAction" method="post">
		<c:if test="${empty loginMember}">
			<input class ="sideber_login_textbox" type="text" name="ID" placeholder="아이디">
			<input class ="sideber_login_textbox" type="password" name="PW" placeholder="비밀번호">
			<br>
			<button type="button" class ="sideber_login_btn" onclick="location.href = 'User_Join.jsp'">회원가입</button>
			<input class ="sideber_login_btn" type="submit" value="로그인" onclick="loginCheck()">
		</c:if>
	</form>
		<c:if test="${loginMember.grade eq '회원'}">
			<ul class ="sideber_user_information">
					<li>${loginMember.nickname}님 어서오세요</li>
					<li>보유 포인트 : ${loginMember.point}</li>
					<li>회원 등급 : ${loginMember.grade}</li>
			</ul>	
			<button class ="sideber_login_btn" onclick="location.href = 'MyPage.jsp'">마이페이지</button>
			<button class ="sideber_login_btn" onclick="location.href = 'Logout.jsp'">로그아웃</button>
		</c:if>
		
		<c:if test="${loginMember.grade eq '관리자'}">
			<ul class ="sideber_user_information">
					<li>${loginMember.nickname}님 어서오세요</li>
					<li>보유 포인트 : ${loginMember.point}point</li>
					<li>회원 등급 : ${loginMember.grade}</li>
			</ul>		
			<button class ="sideber_login_btn" onclick="location.href = 'Admin_management_user.jsp'">관리자페이지</button>
			<button class ="sideber_login_btn" onclick="location.href = 'Logout.jsp'">로그아웃</button>
		</c:if>