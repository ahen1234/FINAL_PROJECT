<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>커뮤니티</title>
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
			<div id="content_index1">
					<table class="content_index_table">
						<caption><a href="Noticeboard.jsp">+더보기</a></caption>
						<tr >
							<th>공지사항</th>
						</tr>
							<c:forEach var="searchResultItem" items="${searchResultList}">
							<tr>
								<!-- 첫번째 줄 시작 -->
								<td>${searchResultItem.emp_name}</td>
							</tr>
							<!-- 첫번째 줄 끝 -->
						</c:forEach>
					</table>
			</div>
			<div id="content_index2">
					<table class="content_index_table" >
						<caption><a href="Forum_free.jsp">+더보기</a></caption>
						<tr >
							<th>자유게시판</th>
						</tr>
							<c:forEach var="searchResultItem" items="${searchResultList}">
							<tr>
								<!-- 첫번째 줄 시작 -->
								<td>${searchResultItem.emp_name}</td>
							</tr>
							<!-- 첫번째 줄 끝 -->
						</c:forEach>
					</table>
			</div>
			<div id="content_index3">
					<table class="content_index_table">
						<caption><a href="Forum_humor.jsp">+더보기</a></caption>
						<tr >
							<th>유머게시판</th>
						</tr>
							<c:forEach var="searchResultItem" items="${searchResultList}">
							<tr>
								<!-- 첫번째 줄 시작 -->
								<td>${searchResultItem.emp_name}</td>
							</tr>
							<!-- 첫번째 줄 끝 -->
						</c:forEach>
					</table>
			</div>
			<div id="content_index4">
					<table class="content_index_table">
						<caption><a href="Noticeboard.jsp">+더보기</a></caption>
						<tr >
							<th>제목</th>
						</tr>
							<c:forEach var="searchResultItem" items="${searchResultList}">
							<tr>
								<!-- 첫번째 줄 시작 -->
								<td>${searchResultItem.emp_name}</td>
							</tr>
							<!-- 첫번째 줄 끝 -->
						</c:forEach>
					</table>
			</div>
		</div>
		
		
		
		<div id="footer">
			<h1>#footer</h1>
		</div>
	</div>
</body>
</html>