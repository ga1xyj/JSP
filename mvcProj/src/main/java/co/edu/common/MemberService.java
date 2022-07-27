package co.edu.common;

public class MemberService {
	//업무 처리 로직
	//싱글톤
	private static MemberService instance = new MemberService();
		//생성자에 의해 초기값 가짐
	private MemberService() {}
	public static MemberService getInstance() {
		return instance;
	}
	
	MemberDAO dao = new MemberDAO();
	//입력기능 삭제
	//입력기능
	//입력기능 수정
	public void memberAdd(MemberVO vo) {
		dao.insertMember(vo);
		//vo값 받아서 insert
	}
}