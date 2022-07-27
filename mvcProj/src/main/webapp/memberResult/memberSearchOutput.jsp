<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과(memberSearchOutput.jsp)</title>
</head>
<body>
	<h3>검색결과</h3>
	<c:if test="${!empty member }">
	<!-- member가 공백이냐 아니냐 조건문 -->
		<p>${member.id } / ${member.name } / ${member.passwd } / ${member.mail }</p>
	</c:if>
	<jsp:include page="./home.jsp"></jsp:include>
</body>
</html>