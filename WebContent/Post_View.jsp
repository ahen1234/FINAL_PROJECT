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
				<table class = "content_board_write">
					<tr>
						<th>제목</th>
					</tr>
					<tr>
						<th></th>
					</tr>
					<c:forEach var="boardreaditem" items="${boardread}" >
						<tr>
							<td><c:out value="${boardreaditem.TITLE}"/></td>
						</tr>
						<tr>
							<td>
								<div style="height: 500px;">
								<c:out value="${boardreaditem.CONTENTS}"/>
								</div>
							</td>
						</tr>
						</c:forEach>
				</table>
			</div>
		</div>
		
		
		
		<div id="footer">
			
		</div>
	</div>
</body>
</html>