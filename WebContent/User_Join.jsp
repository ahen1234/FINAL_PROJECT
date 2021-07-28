<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>온라인 커뮤니티 - 왓츠</title>
<link rel="stylesheet" href="/CSS/Final_Project.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="header_logo_box"><jsp:include page="/layout/header1.jsp" flush="false" /></div>
			<div id="header_search_box"><jsp:include page="/layout/header2.jsp" flush="false" /></div>
		</div>
		
		
		<div id="sidebar">
			<div id ="sidebar_login">
			<jsp:include page="/layout/sidebar1.jsp" flush="false" />
			</div>
			<div id ="sidebar_menu">
			<jsp:include page="/layout/sidebar2.jsp" flush="false" />
			</div>
		</div>
		
		
		<div id="content">
			<div id ="content_board">
				<form action="join" method="post">
					<table class="Infotable">
						<tr>
							<td colspan="2" class="Infotd">회원가입</td>
						</tr>
						<tr>
							<td class="Infotd">아이디</td>
							<td class="Infotd"><input type="text" name="ID"
								placeholder="아이디를 입력해주세요."></td>
						</tr>
						<tr>
							<td class="Infotd">비밀번호</td>
							<td class="Infotd"><input type="password" name="PW"
								placeholder="비밀번호를 입력해주세요."></td>
						</tr>
						<tr>
							<td class="Infotd">닉네임</td>
							<td class="Infotd"><input type="text" name="NICKNAME"
								placeholder="닉네임을 입력해주세요"></td>
						</tr>
						<tr>
							<td class="Infotd">이메일</td>
							<td class="Infotd"><input type="text" name="MAIL"
								placeholder="이메일을 입력해주세요."></td>
						</tr>
						<tr>
							<td colspan="2" class="Infotd"><input type="submit"
								value="가입하기"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		
		
		
	</div>
</body>
</html>