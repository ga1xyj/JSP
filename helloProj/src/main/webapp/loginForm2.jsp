<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.jsp</title>
</head>
<body>
	<%
		//리턴되는 타입 오브젝트라 string으로 캐스팅
		String msg = (String)request.getAttribute("msg");
		if(msg != null){
			//msg가 null이 올수도 있다
			out.print("<p>"+msg+"</p>");
		}
	%>
	<form action="login.jsp" method='post'>
		ID: <input type="text" name="id"><br>
		PW: <input type="password" name="pwd"><br>
		<input type="submit" value="로그인">	
	</form>
</body>
</html>