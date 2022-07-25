package com.tst.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAO {
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
	
	//DB 정보를 가져오는 메소드
	private void dbConfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();
		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			//getSystemClassLoader:클래스 정보
			//getresource:지정한 파일 찾기
			//getPath:파일의 경로
			properties.load(new FileInputStream(filePath));
			//FileInputStream:외부의 파일
			//properties.load:key, value 형태 유지
			//->파일만 수정하면 수정할 수 있음
		}catch (IOException e) {
			e.printStackTrace();
		}
		jdbcDriver = properties.getProperty("driver");
		oracleUrl = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("password");
	}
	
	//public DAO() {
		//dbConfig();
		//정보 가져옴
		//생성자에서 바로 실행
	//}
	
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
}
