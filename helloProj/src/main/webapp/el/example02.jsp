<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tst.board.BoardVO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"
>
<title>el/example02.jsp</title>
</head>
<body>
	<%
		BoardVO vo = new BoardVO();
	//태그라이브러리:태그라이브러리라고 하는 지시자가 들어감 c로쓰기
		String name = "Hong";
	%>
	<c:set var="user" value="user1"></c:set>
	<c:out value="${user }"></c:out>
	<c:set var="p1" value="${param.title }"></c:set>
	<c:set var="p2" value="${param.content }"></c:set>
	<c:set var="p3" value="${param.writer }"></c:set>
	<p><c:out value="${p1 }"></c:out></p>
	<p><c:out value="${p2 }"></c:out></p>
	<p><c:out value="${p3 }"></c:out></p>
</body>
</html>