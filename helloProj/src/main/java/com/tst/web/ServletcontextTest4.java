package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.ShareObject;

@WebServlet("/context4")
public class ServletcontextTest4 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//화면 context 타입
		resp.setContentType("text/html; charset=utf-8");
		
		//객체를 하나 가져와 sc에 담기
		ServletContext sc = this.getServletContext();
		
		//context3의 data주소값 가져오기
		//shareobject타입으로 casting
		//data라는 값을 attribute값으로 읽을 수 있음
		//원래 object타입으로 반환되기 때문에 shareobject로 캐스팅 이렁남
		ShareObject obj1 = (ShareObject)sc.getAttribute("data");
		resp.getWriter().print("count: "+obj1.getCount()+",str:"+obj1.getStr());
		ShareObject obj2 = (ShareObject)sc.getAttribute("data2");
		resp.getWriter().print("count:"+obj2.getCount()+",str:"+obj2.getStr());
	}
}
