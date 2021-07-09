package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MySqlConectTest {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	// 8.0~ "com.mysql.cj.jdbc.Driver"
	private static final String DBURL = "jdbc:mysql://localhost:3306/springdb?useSSL=false";
	// 8.0~
	// "jdbc:mysql://localhost:3306/springdb?useSSL=false&serverTimezone=Asia/Seoul"
	private static final String DBID = "root";
	private static final String DBPW = "1234";

	// Junit사용 테스트
	// @Test
	public void testCon() {
		try {
			// 1. 드라이버 로드
			Class.forName(DRIVER);
			// 2. 디비연결
			Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);

			System.out.println("디비 연결 : " + con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCon2() throws Exception {
		// try - with : 1.7이상의 자바에서 사용, DB연결에 필요한 자원해서 구문을 포함하는 예외처리
		
		//		try(AutoCloseable 인터페이스를 구현한 객체){
		//			
		//		}catch (Exception e) {
		//			
		//		}

		// 1. 드라이버 로드
		Class.forName(DRIVER);
		
		// 2. 디비연결
		try(Connection con = DriverManager.getConnection(DBURL, DBID, DBPW)){
			
			System.out.println("디비 연결 성공! : "+con);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
