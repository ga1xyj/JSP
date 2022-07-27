<%@page import="co.edu.common.MemberVO"%>
<%@page import="co.edu.common.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String pw = request.getParameter("passwd");
	String mail = request.getParameter("mail");
	
	//vo에 값 저장
	MemberVO vo = new MemberVO();
	vo.setId(id);
	vo.setName(name);
	vo.setMail(mail);
	vo.setPasswd(pw);
	
	MemberService service = MemberService.getInstance();
	service.memberAdd(vo);
	
	//member라는 attribute에 vo를 담아서 넘김
	request.setAttribute("member", vo);
	//처리결과:memberOutput.jsp 넘겨줌(vo 객체를 넘겨준다)
	RequestDispatcher rd = request.getRequestDispatcher("memberOutput.jsp");
	rd.forward(request, response);
	//리퀘스트값, 리스폰스 값 담아서 포워딩
	
%>
