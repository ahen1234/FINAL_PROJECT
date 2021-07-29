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
			<c:if test="${param.write eq 'notice'}">
				<p style="font-size: 40px; text-align: center; font-family: cursive;">공지사항</p>
				</c:if>
				<c:if test="${param.write eq 'free'}">
				<p style="font-size: 40px; text-align: center; font-family: cursive;">자유게시판</p>
				</c:if>
				<c:if test="${param.write eq 'humor'}">
				<p style="font-size: 40px; text-align: center; font-family: cursive;">유머게시판</p>
				</c:if>
				<table class="content_board_table" >
				<c:if test="${loginMember.grade eq '관리자' && param.write eq 'notice' }">
					<caption class="content_board_position"><button class ="content_board_btn" onclick="location.href = 'Write_Post.jsp?Write=notice'">글쓰기</button></caption>
				</c:if>	
				<c:if test="${param.write eq 'free' && loginMember.grade != null}">
					<caption class="content_board_position"><button class ="content_board_btn" onclick="location.href = 'Write_Post.jsp?Write=free'">글쓰기</button></caption>
				</c:if>	
				<c:if test="${param.write eq 'humor' && loginMember.grade != null}">
					<caption class="content_board_position"><button class ="content_board_btn" onclick="location.href = 'Write_Post.jsp?Write=humor'">글쓰기</button></caption>
				</c:if>	
					<tr>
						<th class="content_board_th1">게시물번호</th>
						<th class="content_board_th2">제목</th>
						<th class="content_board_th3">작성자</th>
						<th class="content_board_th4">조회수</th>
						<th class="content_board_th4">작성일자</th>
					</tr>
					<c:forEach var="boardlistitem" items="${boardlist}" varStatus="status" end="12">
						<tr>
							<td><c:out value="${status.count}"/></td>
							<td><a href="/boardread?post_code=${boardlistitem.POST_CODE}"><c:out value="${boardlistitem.TITLE}"/></a></td>
							<td><c:out value="${boardlistitem.NICKNAME}"/></td>
							<td><c:out value="${boardlistitem.VIEWS_CUT}"/></td>
							<td><c:out value="${boardlistitem.REPORTING_DATE}"/></td>
						</tr>
						<!-- 첫번째 줄 끝 -->
					</c:forEach>
				</table>		
			</div>
		</div>
	</div>
</body>
</html>