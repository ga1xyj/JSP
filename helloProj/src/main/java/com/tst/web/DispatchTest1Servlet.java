package com.tst.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//값을 받는 페이지
@WebServlet("/dispatch1")
public class DispatchTest1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print("<h3>Dispatch page 1</h3>");
		
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publi = req.getParameter("publish");
		req.setAttribute("param1", title);
		//param1 attribute에 title 값
		req.setAttribute("param2", author);
		req.setAttribute("param3", publi);
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/dispatch2");
		//서블릿 컨텍스트가 가지고 있는 get RequestDispatcher 메소드로
		rd.forward(req, resp); //dispatch2 요청 재지정 //두번째만
		//rd.include(req, resp);
		//첫번째도 두번째도 보여줌
		//디스패치2에서도 요청정보 참조
		
		
	}
}
