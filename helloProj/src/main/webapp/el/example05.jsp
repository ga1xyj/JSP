<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 반복문 -->
	<%
		for(int i=1; i<=10; i++){
			out.print("i: " + i + "<br>");
		}
		String[] str = {"최현정","주은하","주은영"};
		//for(String name : str){
			//System.out.print(name);
		//}
		String fruits = "사과,바나나,수박";
	%>
	<c:set var="names" value="<%=str %>" />
	<c:set var="fruits2" value="<%=fruits %>" />
	
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i }"></c:out><br>
	</c:forEach>
	
	<ul>
		<c:forEach var="name" items="${names }">
			<li>${name }</li>
		</c:forEach>
	</ul>
	
	<ul>
		<!-- ,로 문자열구분 -->
		<c:forTokens items="${fruits2 }" delims="," var="fruit">
		<li>${fruit }</li>
		</c:forTokens>
	</ul>
</body>
</html>