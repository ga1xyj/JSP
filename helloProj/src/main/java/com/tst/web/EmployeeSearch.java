package com.tst.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.EmpDAO;
import com.tst.common.Employee;

@WebServlet("/empSearch")
public class EmployeeSearch extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fName = req.getParameter("first_name");
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpInfo(fName);
		req.setAttribute("data", list);
		//데이터값으로 list객체의 주소값 연결
		
		RequestDispatcher rd = req.getRequestDispatcher("empResult.jsp");
		//empResult라는 페이지 호출
		rd.forward(req, resp);
		//요청정보와 응답정보를 매개값으로
	}
}
