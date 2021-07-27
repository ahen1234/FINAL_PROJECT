<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>커뮤니티 - 글작성</title>
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
			<div id ="content_board5555">
				<form action="Notice" method="post">
					<table class = "content_board_write">
					<caption style="font-size: 40px; text-align: center; font-family: cursive;">글작성</caption>
						<tr>
							<td>
							<input class="content_board_write_title" type="hidden" name="nickname" value="${loginMember.nickname}" >
							<input class="content_board_write_title" type="hidden" name="id" value="${loginMember.id}" >
							</td>
						</tr>
						<tr>
							<td>제목 : <input class="content_board_write_title" type="text" name="TITLE"></td>
						</tr>
						<tr>
							<td>사진첨부 :</td>
						</tr>
						<tr>
							<td><textarea class ="content_board_contents" name="CONTENTS"></textarea></td>
						</tr>
						<tr>
						<td><input type="hidden" name ="BOARD" value="${param.Write}"></td>
						</tr>
						<tr>
							<td><input class = "content_board_btn" type="submit" value="등록"></td>
						</tr>
						
					</table>
				</form>
			</div>
		</div>
		
		
		
		<div id="footer">
			
		</div>
	</div>
</body>
</html>