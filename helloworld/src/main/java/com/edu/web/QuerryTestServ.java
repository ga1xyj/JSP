package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/queryTest")
public class QuerryTestServ extends HttpServlet{
	//get방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		//id파라미터 값을 읽어서 반환해줌
		//중요
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby");
		//여러개 가져와줌 배열
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduction = req.getParameter("introduction");
		//요청방식은 헤더쪽에 들어감
		
		out.print("<h3>입력받은 값</h3>");
		out.print("<p>ID: "+id+"</p>");
		out.print("<p>비밀번호: "+pwd+"</p>");
		out.print("<p>이름: "+name+"</p>");
		out.print("<p>취미: <ul>");
		for(String list:hobby) {
			out.print("<li>"+list+"</li>");
		}
		out.print("</ul>");
		out.print("<p>성별: "+gender+"</p>");
		out.print("<p>종교: "+religion+"</p>");
		out.print("<p>자기소개: "+introduction+"</p>");
		out.print("질의문자열: "+req.getQueryString());
		out.close();
	}
	//post방식
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청정보도 한글 해주기
		//req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		//파라미터가 2개면 겹치기 때문에 질의문자열이 안나옴 따라서 주석처리
		/*
		String id = req.getParameter("id");
		//id파라미터 값을 읽어서 반환해줌
		//중요
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby");
		//여러개 가져와줌 배열
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduction = req.getParameter("introduction");
		//요청방식은 헤더쪽에 들어감
		
		/*out.print("<h3>입력받은 값</h3>");
		out.print("<p>ID: "+id+"</p>");
		out.print("<p>비밀번호: "+pwd+"</p>");
		out.print("<p>이름: "+name+"</p>");
		out.print("<p>취미: <ul>");
		for(String list:hobby) {
			out.print("<li>"+list+"</li>");
		}
		out.print("</ul>");
		out.print("<p>성별: "+gender+"</p>");
		out.print("<p>종교: "+religion+"</p>");
		out.print("<p>자기소개: "+introduction+"</p>");*/
		//post 입력 방식 !!!!! 
		ServletInputStream sis = req.getInputStream();
		//post방식일 경우에 들어오는 정보가 입력스트림으로
		int len = req.getContentLength(); //데이터크기
		byte[] buf=new byte[len];
		sis.readLine(buf, 0, len);
		//buf의 처음부터 끝까지 읽어들임
		String queryString = new String(buf);
		out.print("<p id='querystring'>"+queryString+"</p>");
		sis.close();
		out.close();
	}
}
