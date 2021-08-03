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
			<form action="">
					<table border="1">
						<tr>
							<td colspan="2">마이페이지</td>
						</tr>
						<tr>
							<td>아이디</td>
							<td><input type="text" value="${loginMember.id}" disabled></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" value="${loginMember.pw}"
								disabled></td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td><input type="text" value="${loginMember.nickname}"
								disabled></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="text" value="${loginMember.mail}" disabled></td>
						</tr>
						<tr>
							<td>가입일자</td>
							<td><input type="text" value="${loginMember.joindate}" disabled></td>
						</tr>
						<tr>
							<td><button type="button"
									onclick="location.href='Editprofile.jsp'">정보수정</button></td>
							<td><button type="button"
									onclick="location.href='DeleteAccount.jsp'">회원탈퇴</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>