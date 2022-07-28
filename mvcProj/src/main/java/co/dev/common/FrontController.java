package co.dev.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

//서블릿
public class FrontController extends HttpServlet {
	String enc;
	Map<String, Controller> mappings;
	//controller값을 value로 가짐
	

	// 맨처음 실행되는 메소드
	@Override
	public void init(ServletConfig config) throws ServletException {
		enc = config.getInitParameter("charset");
		mappings = new HashMap<>();
		mappings.put("/memberInsert.do", new MemberInsertcontroller());
		mappings.put("/memberList.do", new MemberListController());
		mappings.put("/memberSearch.do", new MemberSearchController());
		mappings.put("/memberUpdate.do", new MemberUpdateController());
		mappings.put("/memberDelete.do", new MemberDeleteController());
		mappings.put("/memberJson.do", new MemberJsonController());
	}

	// 호출될때마다 실행되는 메소드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc);
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		System.out.println(path);
		// 등록요청인지 목록요청인지 구분하고 싶음
		// 입력 -> 뷰페이지
		// 요청정보 파라미터 id값을 읽어서
		
		Controller cntrl = mappings.get(path);
		cntrl.execute(req, resp);
		
	}
}
