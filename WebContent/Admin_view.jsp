<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/CSS/Final_Project.css">
		<form action="" method="post">
				<table class="content_board_table" >
				<caption class="content_board_position">회원 정보</caption>
					<tr>
						<th>아이디</th>
						<th>닉네임</th>
						<th>메일</th>
						<th>가입일자</th>
						<th></th>
					</tr>
					<c:forEach var="Memberlistitem" items="${Memberlist}" varStatus="status" end="12">
						<tr>
							<td><c:out value="${Memberlistitem.id}"/></td>
							<td><c:out value="${Memberlistitem.nickname}"/></td>
							<td><c:out value="${Memberlistitem.mail}"/></td>
							<td><c:out value="${Memberlistitem.joindate}"/></td>
							<td><input type="checkbox" ></td>
						</tr>
						<!-- 첫번째 줄 끝 -->
					</c:forEach>
				</table>
				</form>		
