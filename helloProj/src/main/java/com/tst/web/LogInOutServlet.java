package com.tst.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		if(id.isEmpty()||pwd.isEmpty()) {
			out.print("ID와 비밀번호를 입력해주세요");
			return;
		}
		HttpSession session = req.getSession();
		//값을 가져왔더니 null일때
		if(session.isNew() || session.getAttribute("id")==null) {
			session.setAttribute("id", id);
			//session이 있으면 값 담아줌
			out.print("로그인을 완료했습니다");
		}else {
			out.print("현재 로그인 중입니다.");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession(false);
		//요청정보를 가지고 있는 겟 세션
			//있으면 쓰고 없으면 null 리턴
		if(session != null && session.getAttribute("id")!=null) {
			session.invalidate();
			//세션 삭제 메소드
			out.print("로그아웃 완료했습니다.");
		}else {
			out.print("현재 로그인 상태가 아닙니다.");
		}
	}
}
