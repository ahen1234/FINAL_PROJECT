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
				<!--<jsp:include page="Admin_view.jsp" flush="false" />-->
			</div>
		</div>
	</div>
</body>
</html>