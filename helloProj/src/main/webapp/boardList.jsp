<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tst.board.BoardVO" %>
<%@page import="com.tst.board.BoardDAO" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/*String id = (String) session.getAttribute("loginId");
	if(id!=null){
		out.print("<h3>"+id+"님으로 로그인되었습니다.</h3>");
		out.print("<a href='logout.jsp'>로그아웃</a>");
	}else{
		out.print("<h3>손님입니다.</h3>");
	}*/
	%>
	<!-- 비어있지 않다!empty -->
	<c:choose>
		<c:when test="${!empty loginId }">
			<h3><c:out value="${loginId }"></c:out>님으로 로그인했습니다.</h3>
		</c:when>
		<c:otherwise><h3>손님입니다.</h3></c:otherwise>
	</c:choose>
	
	
<table border="1">
<thead>
	<tr>
	<th>글번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th>
	</tr>
</thead>
	<tbody>
 <%
	BoardDAO dao = new BoardDAO();
	List<BoardVO> list = dao.boardList();
	//for(BoardVO vo : list){
%>
	<c:set var="boards" value="<%=list %>" />
	<c:forEach var="vo" items="${boards }">
	
	<tr>
		<td><a href="boardDetail.jsp?id=${vo.boardId }">${vo.boardId }</a></td>
		<td>${vo.title }</td>
		<td>${vo.writer }</td>
		<td>${vo.createDate }</td>
		<td>${vo.cnt }</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<a href="addBoard.jsp">글작성</a>
<a href="logout.jsp">로그아웃</a>
</body>
</html>