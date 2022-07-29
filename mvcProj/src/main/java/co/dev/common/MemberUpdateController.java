package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//파라미터
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String nm = req.getParameter("name");
		String em = req.getParameter("mail");
		
		MemberVO vo = new MemberVO();
		//넘어온 파라미터 vo값으로 담기
		vo.setId(id);
		vo.setMail(em);
		vo.setName(nm);
		vo.setPasswd(pw);
		
		MemberService service = MemberService.getInstance();
		service.modifyMember(vo);
		
		// 공유 : vo
		req.setAttribute("member", vo);
		Utils.forward(req, resp, "memberResult/memberUpdateOutput.jsp");
		//처리 결과 넘김 
		
	}
}
