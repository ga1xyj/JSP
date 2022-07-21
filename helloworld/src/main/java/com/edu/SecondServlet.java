package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second.do")
//이 서블릿을 열어주겠습니다
public class SecondServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.getWriter(); //출력스트림
		resp.setContentType("text/html;charset=UTF-8"); //응답정보에 컨텐트 타입 지정해줌
		PrintWriter out = resp.getWriter();		//리턴타입:printWriter
		out.print("<h3>안녕하세요. 서블릿입니다</h3>");
	}
}
