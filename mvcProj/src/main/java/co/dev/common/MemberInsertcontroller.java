package co.dev.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberInsertcontroller implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = MemberService.getInstance();

			String id = req.getParameter("id");
			String pw = req.getParameter("passwd");
			String nm = req.getParameter("name");
			String ml = req.getParameter("mail");
			MemberVO vo = new MemberVO();
			
			vo.setId(id);
			vo.setName(nm);
			vo.setPasswd(pw);
			vo.setMail(ml);
			
			service.addMember(vo);
			req.setAttribute("member", vo);
			/*RequestDispatcher rd = req.getRequestDispatcher("memberResult/memberInsertOutput.jsp");
			// 요청 재지정
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			Utils.forward(req, resp, "memberResult/memberInsertOutput.jsp");
		}

	}


