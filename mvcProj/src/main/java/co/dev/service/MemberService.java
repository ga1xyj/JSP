package co.dev.service;

import co.dev.vo.MemberVO;

import java.util.List;

import co.dev.dao.MemberDAO;

//비즈니스 처리
public class MemberService {
	//여기에서 로직 구성
	//싱글톤 방식
	private static MemberService instance = new MemberService();
	MemberDAO dao = new MemberDAO();
	
	private MemberService() {}
	public static MemberService getInstance() {
		return instance;
	}
	
	//회원가입
	public void addMember(MemberVO vo) {
		dao.insertMember(vo);
	}
	
	//회원목록
	public List<MemberVO> memberList(){
		return dao.getList();
	}
	
	//회원조회
	public MemberVO getMember(String id) {
		return dao.searchMember(id);
	}
}
