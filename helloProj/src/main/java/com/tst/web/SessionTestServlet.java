package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		//httpservlet이 가지고 있는 sesison
		//1)httpSession타입
		HttpSession session = null;
		
		//요청값으로 파라미터 넘기기("p")값
		//파라미터로 값을 넘기면 세션값이 생김
		String param = req.getParameter("p");
		
		//새로 만들어졌는지 아닌지 세션 담을 변수
		String msg = null;
		
		//생성, 변경, 삭제
		//만들어진 세션이 없으면 삭제할 객체 없음 -> create 후 세션 객체 삭제
		if(param.equals("create")) {
			//이미 생성되어진 세션 값이 있으면 그 session Id를 반환
			//만약에 없으면 새로 생성해서 생성된 session값을 반환해줌
			//세션값이 있으면 세션반환(파라미터 값이 true와 같음)
			session = req.getSession(true); 
			//요청값에 getSession
			//isNew():세션값이 지금 만들어졌는지 이전에 만들어졌는지 확인하는 메소드
			if(session.isNew()) {
				//새로 만들어졌다면 이번에 만들어진 세션값을 반환
				msg = "새로운 세션 객체 생성";
			}else {
				//그렇지 않다면 이전에 만들어진 session 값을 반환
				msg = "기존 세션 객체 반환";
			}
		}else if(param.equals("delete")) {
			//새로 생성된 세션이 없으면 null 반환
			session = req.getSession(false);
			if(session!=null) {
				//null이 아니면 반환된 값이 있어서 해당 세션 삭제 가능
				//세션 삭제 메소드:invalidate
				session.invalidate();
				msg="세션 객체 삭제";
			}else {
				msg="삭제할 세션 객체 없음";
			}
			//edge랑 chrom이랑 다르게 열어보기(접속유저가 다름에 따라 출력문도 다름)
			//but, chrom안에 두 개의 창으로 열면 같은 유저로 인식해서 메세지 추가가 나옴
			//브라우저가 다르면 세션 공유가 안됨(다른유저로 인식)
		}else if(param.equals("add")) {
			//세션이 있으면 세션을 가져오는 메소드(default값 true)
			session = req.getSession(true);
			//String도 object타입
			session.setAttribute("msg","메세지 추가");
			msg = "세션 객체에 속성(msg값) 지정";
		}else if(param.equals("get")) {
			//기존 세션 객체가 없으면 null
			session = req.getSession(false);
			if(session != null) {
				//이미 만들어진 세션이 있다는 것
				//리턴타입:object type
				//msg의 내용을 string으로 받아 다시 msg에 넣기
				String str =(String)session.getAttribute("msg");
				msg = str;
			}else {
				msg="데이터를 추출할 세션이 없습니다";
			}
		}else if(param.equals("remove")) {
			//값을 지정 안해도됨 없으면 null값이 반환되니까
			//세션이 있을 경우에만 attribute 삭제
			session = req.getSession(false);
			//있다면 삭제
			if(session != null) {
				session.removeAttribute("msg");
				msg="세션 객체의 속성을 삭제";
			}else {
				msg="속성을 제거할 객체가 없음";
			}
		}
		resp.getWriter().print("처리결과:"+msg);
	}
}
