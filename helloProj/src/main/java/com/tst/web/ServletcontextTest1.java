package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context1")
public class ServletcontextTest1 extends HttpServlet{
	ServletContext sc;//전역변수
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		sc = config.getServletContext();
		//servletConfig 객체 통해서 컨텍스트 가져오는 방식
		System.out.println(sc);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loc = sc.getInitParameter("contextConfigLocation");
		resp.getWriter().print("Location: "+loc);
		
		String con = sc.getInitParameter("contextConfig");
		resp.getWriter().print("Config: "+con);
		//모든 서블릿에서는 컨텍스트값 읽을수있다
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String enc = sc.getInitParameter("encoding");
		System.out.println(enc);
		//파라미터로 가져옴(인코딩값을 UTF-8로 지정함)
		req.setCharacterEncoding(enc);
		resp.setCharacterEncoding(enc);
		resp.setContentType("text/plain;charset=utf-8");
		//둘다 인코딩해주기
		String name = req.getParameter("name");
		System.out.println(name);
		resp.getWriter().print("이름: " + name);
		//요청정보요청
		//인코딩에 매핑되어있는 값을 불러와서 인코딩함
		
	}
}
