<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정검색(memberUpdate.jsp)</title>
</head>
<body>
	<h3>회원검색</h3>
		${error }
	<form action="${pageContext.request.contextPath }/memberSearch.do" method="post">
		아이디:<input type="text" name="id"><br>
		<input type="hidden" name="job" value="update">
		<!-- 화면에 보여지지 않음 -->
		<input type="submit" value="조회">
	</form>
	<c:set var="vo" value="${member }" />
	<!-- vo에 값을 담음 -->
	<c:choose>
		<c:when test="${!empty vo }"><!-- 값이 있으면 -->
			<form action="${pageContext.request.contextPath }/memberUpdate.do" method="post">
				아이디: <input type="text" name="id" value="${vo.id }" readonly ><br>
				비밀번호:<input type="text" name="passwd" value="${vo.passwd }"><br>
				이름:<input type="text" name="name" value="${vo.name }"><br>
				이메일:<input type="text" name="mail" value="${vo.mail }"><br>
				<input type="submit" value="수정">
			</form>
		</c:when>
		<c:otherwise>
			<p>${result }</p>
		</c:otherwise>
	</c:choose>
</body>
</html>