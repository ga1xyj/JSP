package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberDeleteController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		
		//MemberVO vo = new MemberVO();
		//넘어온 파라미터 vo값으로 담기
	
		MemberService service = MemberService.getInstance();
		service.removeMember(id);
		
		req.setAttribute("member", id);
		Utils.forward(req, resp, "memberResult/memberDeleteOutput.jsp");
	}
}
