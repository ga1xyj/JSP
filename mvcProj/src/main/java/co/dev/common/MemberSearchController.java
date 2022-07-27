package co.dev.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberSearchController implements Controller {
	//조회 기능
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		//파라미터 id값 넘기기
		if(id.isEmpty()) {
			//error속성에 메세지
			req.setAttribute("error", "id를 입력하세요.");
			if(job.equals("search")) {
			Utils.forward(req, resp, "memberView/memberSearch.jsp");
			}else if(job.equals("update")) {
			Utils.forward(req, resp, "memberView/memberUpdate.jsp");
			}
			//id가 없다면 돌려보냄
			return;
			//return 만나면 메소드 중단
		}
		MemberService service = MemberService.getInstance();
		MemberVO vo = service.getMember(id);
		if(vo == null) {
			req.setAttribute("result", "검색된 정보가 없습니다");
		}
		req.setAttribute("member", vo);
		
		req.setAttribute("member", service.getMember(id));
		if(job.equals("search")) {
			Utils.forward(req, resp, "memberResult/memberSearchOutput.jsp");
		}else if(job.equals("update")) {
			Utils.forward(req, resp, "memberView/memberUpdate.jsp");
		}
		/*try {
			req.getRequestDispatcher("memberResult/membSearchOutput.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
