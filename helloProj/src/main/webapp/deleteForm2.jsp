<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tst.board.BoardDAO" %>
<%@page import="com.tst.board.BoardVO" %>
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
	%>
	<form action="delete.jsp">
	<table border="1">
		<tr><th>글번호</th><td><input type="text" name="bid" value="<%=vo.getBoardId() %>" readonly></td></tr>
		<tr><th>제목</th><td><input type="text" name="btitle" value="<%=vo.getTitle() %>"></td></tr>
		<tr><th>내용</th><td><input type="text" name="bcontent" value="<%=vo.getContent() %>"></td></tr>
		<tr><th>작성자</th><td><input type="text" name="bwriter" value="<%=vo.getWriter() %>"></td></tr>
		<tr><td colspan="2"><input type="submit" value="삭제" 
		<%String loginId = (String) session.getAttribute("loginId");
		if(loginId == null || !(loginId.equals(vo.getWriter()))) {%>
		disabled
		<%}%>>
		</td></tr>
	</table>
	</form>
</body>
</html>