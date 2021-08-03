<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>온라인 커뮤니티 - 왓츠</title>
<link rel="stylesheet" href="/CSS/Final_Project.css?a">
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
			<div>
				<table class="content_Post_table">
					<tr class= "content_Post_tr">
						<td>
						<textarea rows="1px" cols="117px" disabled="disabled" style="font-size: 20px; font-family: cursive; resize: none; background-color: white;"><c:out value="${boardread.TITLE}" /></textarea>
						<textarea rows="1px" cols="" disabled="disabled" style="font-size: 20px; font-family: cursive; resize: none; background-color: white;"><c:out value="${boardread.REPORTING_DATE}" /></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<textarea rows="100%" cols="140px" disabled="disabled" style="font-size: 20px; font-family: cursive; resize: none; background-color: white;"><c:out value="${boardread.CONTENTS}" /></textarea>
						</td>
					</tr>
				</table>
					<form action="/Commentwrite" method="post">
						<table>
							<tr>
								<td>
								<input type="text" name="comment">
								<input type="hidden" name="id" value="${loginMember.id}"> 
								<input type="hidden" name="nickname" value="${loginMember.nickname}"> 
								<input type="hidden" name="post_code" value="${param.post_code}"> 
								</td>
								<td><input type="submit" value="등록"></td>
							</tr>
							<caption>댓글</caption>
							<c:forEach var="Commentlistitem" items="${commentlist}">
								<tr>
									<td class= "content_PostComment_td"><c:out value="${Commentlistitem.COMMENTS}" /></td>
									<td><c:out value="${Commentlistitem.NICKNAME}" /></td>
									<td><c:out value="${Commentlistitem.COMMENT_DATE}" /></td>
								</tr>
							</c:forEach>
						</table>
					</form>
					<table>
					
				</table>		
				</div>
				
			</div>
		</div>
</body>
</html>