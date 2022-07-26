<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tst.board.BoardDAO" %>
<%@page import="com.tst.board.BoardVO" %>
<%
	String id = request.getParameter("bid");
	String title = request.getParameter("btitle");
	String content = request.getParameter("bcontent");
	
	BoardDAO dao = new BoardDAO();
	BoardVO vo = new BoardVO();
	dao.deleteBoard(Integer.parseInt(id));
	
	response.sendRedirect("boardList.jsp");
%>