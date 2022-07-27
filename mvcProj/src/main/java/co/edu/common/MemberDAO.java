package co.edu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class MemberDAO{
		//Oracle DB 정보
		private String jdbcDriver="oracle.jdbc.driver.OracleDriver";
		private String oracleUrl="jdbc:oracle:thin:@localhost:1521:xe";
		private String connectedId="hr";
		private String connectedPwd="hr";
		
		//공통으로 사용되는 필드 
		protected Connection conn;
		protected Statement stmt;
		protected PreparedStatement pstmt;
		protected ResultSet rs;
		
		//DB에 접속하는 메소드
		public void connect() {
			try {
				Class.forName(jdbcDriver);
				//jdbcDriver 로딩
				conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
			}catch(ClassNotFoundException e) {
				System.out.println("jdbc driver 로딩 실패");
			}catch(SQLException e) {
				System.out.println("DB 연결 실패");
			}
			
		}
		
		//DB 접속을 해제하는 메소드 
		public void disconnect() {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				//null일때 close하면 nullpointexception 발생 
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//입력처리
		public void insertMember(MemberVO vo) {
			String sql = "insert into member(id, name, passwd, mail) values(?,?,?,?)";
			connect();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getName());
				pstmt.setString(3, vo.getPasswd());
				pstmt.setString(4, vo.getMail());
				int r = pstmt.executeUpdate();
				System.out.println(r + "건 입력.");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			
		}
		
	}


