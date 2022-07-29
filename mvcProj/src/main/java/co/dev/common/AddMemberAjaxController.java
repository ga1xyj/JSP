package co.dev.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class AddMemberAjaxController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//회원정보 등록 -> json 타입으로 값을 반환
			//컨텐트 타입을 json 타입으로 지정
		resp.setContentType("text/json;charset=utf-8");
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
		//포워딩 할 필요 없음
		
		//gson 객체를 통해 json 타입으로 반환
		Gson gson = new GsonBuilder().create();
		try {
			resp.getWriter().print(gson.toJson(vo)); //id, name, passwd, mail 가져옴
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
