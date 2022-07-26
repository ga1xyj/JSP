<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example03.jsp</title>
</head>
<body>
	<%
		String param = request.getParameter("msg");
	%>

	<c:catch var="ex">
		<%
			if(param.equals("add")){
				out.print(param);
			}
		%>
	</c:catch>
	<c:out value="${ex }"></c:out>
	<!-- cout에 해당하는 변수값 출력(예외) -->
	<!-- java.lang.NullPointerException라는 예외가 출력됨 -->
</body>
</html>