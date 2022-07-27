<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberOutput.jsp</title>
</head>
<body>
	<c:set var="member" value="${member }"></c:set>
	<p><c:out value="${member.name }"></c:out>님 가입완료</p>
</body>
</html>