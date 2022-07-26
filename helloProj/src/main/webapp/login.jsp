<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tst.board.BoardDAO"%>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//로그인 시도시 에러 메세지 전달하기
	RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
	
	
	BoardDAO dao = new BoardDAO();
	if(dao.loginCheck(id, pwd) == null) {
		//값이 없으면 loginForm으로 이동
		request.setAttribute("msg", "아이디와 비밀번호를 확인하세요.");
		response.sendRedirect("loginForm.jsp");
	}else {
		session.setAttribute("loginId", id);
		response.sendRedirect("boardList.jsp");
		//그렇지 않으면 목록으로 
	}
	
%>