<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tst.common.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empResult.jsp</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr><th>사원번호</th><th>이름</th><th>이메일</th><th>급여</th><tr>
	<%
		request.getParameter("first_name");
		List<Employee> list = (List<Employee>)request.getAttribute("data");
		for(Employee emp : list){
			//<% %안만 자바 영역  
	%>	
		<tr><td><%=emp.getEmployeeId() %></td><td><%=emp.getFirstName() %></td>
			<td><%=emp.getEmail() %></td><td><%=emp.getSalary() %></td>
		</tr>
	<%
			//out.print("사원번호:"+emp.getEmployeeId()+", 사원이름"+", 직무:"+emp.getJobId());
		}
		//자바소스와 html 소스 둘다 사용 가능
		//자바 소스는 <% %'>안에 
	
	%>
	</table>
</body>
</html>