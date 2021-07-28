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
	
				<form action="/UserJoin" method="post">
					<table >
						<tr>
							<td colspan="2">회원가입</td>
						</tr>
						<tr>
							<td >아이디</td>
							<td ><input type="text" name="ID"
								placeholder="아이디를 입력해주세요."></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td ><input type="password" name="PW"
								placeholder="비밀번호를 입력해주세요."></td>
						</tr>
						<tr>
							<td >닉네임</td>
							<td ><input type="text" name="NICKNAME"
								placeholder="닉네임을 입력해주세요"></td>
						</tr>
						<tr>
							<td >이메일</td>
							<td ><input type="text" name="MAIL"
								placeholder="이메일을 입력해주세요."></td>
						</tr>
						<tr>
							<td colspan="2" class="Infotd"><input type="submit"
								value="가입하기"></td>
						</tr>
					</table>
				</form>
		
</body>
</html>