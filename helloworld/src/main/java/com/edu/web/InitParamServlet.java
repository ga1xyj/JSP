package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet{
	//생성(생성자)-> 서블릿컨피그 -> init() -> service(rq, rs)
	//서블릿컨피그:서블릿의 파라미터를 읽어들이는 객체
	//서블릿컨피그의 객체가 init()의 매개값이됨
	String id;
	String pw;
	//필드 영역에 선언
	
	public InitParamServlet() {
		System.out.println("InitParamServlt() 호출");
	}
		
	@Override
	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("id");
		pw = config.getInitParameter("password");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3>서블릿 초기변수 설정</h3>");
		out.print("<p> ID: "+id+"</p>");
		out.print("<p> 비번: "+pw+"</p>");
		out.close();
	}
}
