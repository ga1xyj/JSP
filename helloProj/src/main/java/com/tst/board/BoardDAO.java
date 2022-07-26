package com.tst.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tst.common.DAO;

public class BoardDAO extends DAO{
	//등록
	public void insertBoard(BoardVO vo) {
		String sql = "insert into board values((select nvl(max(board_id), 0)+1 from board), ?, ?, ?, sysdate, 0)";
		connect();//conn객체
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 입력.");
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
		
	
	//목록
	public List<BoardVO> boardList() {
		connect();
		String sql = "select * from board order by 1";
		//오름차순
		List<BoardVO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt("board_id")
										, rs.getString("title")
										, rs.getString("content")
										, rs.getString("writer")
										, rs.getString("create_date")
										, rs.getInt("cnt"));
				list.add(vo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//단건조회
	public BoardVO getBoard(int boardNo) {
		String sql="select * from board where board_id = ?";
		connect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			//단건이니까 while말고 if로 조회
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoardId(boardNo);
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreateDate(rs.getString("create_date"));
				vo.setCnt(rs.getInt("cnt"));
				//카운트 증가 메소드 호출
				setCnt(boardNo);
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return null;
	}
	//조회수 증가 
	public void setCnt(int boardNo) {
		String sql = "update board set cnt=cnt+1 where board_id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//글 내용 수정
	public void updateBoard(BoardVO vo) {
		String sql = "update board set title=?, content=? where board_id=?";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBoardId());
			int r = pstmt.executeUpdate();//쿼리실행
			System.out.println(r+"건 변경.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}	
	}
	
	//삭제
	public void deleteBoard(int boardNo) {
		String sql = "delete board where board_id=?";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 삭제.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	
	//로그인 체크
	public UserVO loginCheck(String id, String pass) {
		String sql = "select * from users where id =? and passwd=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				UserVO vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return null;
	}
	
}
