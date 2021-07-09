package com.itwillbs.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)

public class MyBatisTest {

	// MyBatis를 사용해서 DB연결 테스트
	
	// MyBatis 연결하는 객체 생성 -> 객체를 필요함 -> 객체를 의존
	// 의존 관계를 주입(root-context.xml)
	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	// SqlSessionFactory 객체 주입 확인(테스트)
	
	@Test
	public void testFactory() {
		System.out.println("SqlSessionFactory 객체 주입 확인(테스트)");
		System.out.println(sqlFactory);
	}
	
	// SqlSessionFactory 객체 사용 -> 디비 연결확인(테스트)
	public void testConnect() {
		SqlSession session = sqlFactory.openSession();
		
		System.out.println("연결정보 확인 : " + session);
		
		// session.select
	}
	
}
