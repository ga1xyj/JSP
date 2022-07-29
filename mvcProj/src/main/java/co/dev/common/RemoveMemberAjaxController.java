package co.dev.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;


public class RemoveMemberAjaxController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//삭제처리->json 반환
		String id = req.getParameter("id");
		resp.setContentType("text/json;charset=utf-8");
		MemberService service = MemberService.getInstance();
		boolean isDeleted = service.removeMember(id);
		
		//{"retConde" : "Success"}
		try {
			if(isDeleted)
				resp.getWriter().print("{\"retCode\": \"Success\"}");
			else
				resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
