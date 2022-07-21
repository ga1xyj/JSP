package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reqInfo")
public class RequestInfoServ extends HttpServlet{
	//init()->request, response -> service()
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8"); //형식으로 지정
		//네트워크 정보
		PrintWriter out = resp.getWriter();
		out.print("<h3>네트워크정보</h3>");
		out.print("<p>Request Schema:"+req.getScheme()+"</p>");
		//스키마 확인
		out.print("<p>Server Name:"+req.getServerName()+"</p>");
		out.print("<p>Server Address:"+req.getLocalAddr()+"</p>");
		out.print("<p>Server Port:"+req.getServerPort()+"</p>");
		out.print("<p>Client Address:"+req.getRemoteAddr()+"</p>");
		out.print("<p>Client Host:"+req.getRemoteHost()+"</p>");
		out.print("<p>Client Port:"+req.getRemotePort()+"</p>");
		
		String str = "<h3>URL정보</h3>";
		str += "<p>Reauest URI: " + req.getRequestURI() + "</p>";
		str += "<p>Reauest URL: " + req.getRequestURL() + "</p>";
		str += "<p>Reauest Path: " + req.getContextPath() + "</p>";
		str += "<p>Reauest Protocol: " + req.getProtocol() + "</p>";
		str += "<p>Servlet Path" + req.getServletPath() + "</p>";
		str += "<h3>요청헤더 정보</h3>";
		//한건한건 가져옴
		Enumeration<String> en = req.getHeaderNames();
		while(en.hasMoreElements()) {
			 String elem = en.nextElement();
			 String headVal = req.getHeader(elem);
			 str += "<p>"+elem+", "+headVal+"</p>";
					 //elem:헤더에대한 키값
		}
		out.print(str);
		out.close();
		
	}
}
