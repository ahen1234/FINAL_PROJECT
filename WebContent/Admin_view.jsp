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
			<jsp:include page="/layout/sidebar3.jsp" flush="false" />
			</div>
		</div>
		
		
		<div id="content">
			<div id ="content_board">
				<form action="" method="post">
				<table class="content_board_table" >
				<caption>회원 정보</caption>
					<tr>
						<th></th>
						<th>아이디</th>
						<th>닉네임</th>
						<th>Emali</th>
						<th>가입일자</th>
						<th></th>
					</tr>
					<c:forEach var="Memberlistitem" items="${Memberlist}" varStatus="status" end="12">
						<tr>
							<td><input type="checkbox" ></td>
							<td><c:out value="${Memberlistitem.id}"/></td>
							<td><c:out value="${Memberlistitem.nickname}"/></td>
							<td><c:out value="${Memberlistitem.mail}"/></td>
							<td><c:out value="${Memberlistitem.joindate}"/></td>
							<td><button>회원 탈퇴</button></td>
						</tr>
						<!-- 첫번째 줄 끝 -->
					</c:forEach>
				</table>
				</form>		

			</div>
		</div>
	</div>
</body>
</html>	