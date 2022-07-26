<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tst.board.BoardDAO" %>
<%@page import="com.tst.board.BoardVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String bno = request.getParameter("bno");
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(Integer.parseInt(bno));
		String loginId = (String) session.getAttribute("loginId");
	%>
	<c:set var="vo" value="<%=vo %>" />
	<c:set var="loginId" value="<%=loginId %>" />
	
	<form action="delete.jsp">
	<table border="1">
		<tr><th>글번호</th><td><input type="text" name="bid" value="${vo.boardId }" readonly></td></tr>
		<tr><th>제목</th><td><input type="text" name="btitle" value="${vo.title }"></td></tr>
		<tr><th>내용</th><td><input type="text" name="bcontent" value="${vo.content }"></td></tr>
		<tr><th>작성자</th><td><input type="text" name="bwriter" value="${vo.writer }"></td></tr>
		<tr><td colspan="2"><input type="submit" value="삭제"
		<c:if test="${loginId == null || loginId != vo.writer}">
		disabled
		</c:if>>
		</td></tr>
	</table>
	</form>
</body>
</html>