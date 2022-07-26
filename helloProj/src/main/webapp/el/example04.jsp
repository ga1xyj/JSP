<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example04.jsp</title>
</head>
<body>
	<c:set var="num" value="${70 }"></c:set>
	<!-- num이라는 변수에 80이라는 값 담기 -->
	점수 <c:out value="${num }" />점은
	<!-- c:if조건문 오직 if만 가능 -->
	<c:if test="${num >= 60}">
		합격입니다.
	</c:if>
	<c:if test="${num lt 60 }">
	<!-- 60보다 작으면 -->
	불합격입니다.
	</c:if>

	<!-- if else=c:choose -->
	<br>
	점수 <c:out value="${num }" />점은
	<c:choose>
		<c:when test="${num >= 90 }">A등급입니다.</c:when>
		<c:when test="${num >= 80 }">B등급입니다.</c:when>
		<c:when test="${num >= 70 }">C등급입니다.</c:when>
		<c:otherwise>D등급입니다.</c:otherwise>
	</c:choose>
</body>
</html>