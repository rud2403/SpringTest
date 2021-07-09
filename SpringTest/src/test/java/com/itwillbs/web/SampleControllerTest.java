package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// 스프링 MVC 형태로 테스트


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		)

public class SampleControllerTest {
	// 테스트 파일 => 서버없이 테스트
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController5.class);
	
	// 컨트롤러를 실행하는데 필요한 정보를 주입
	// root-context.xml, servlet-context.xml에서 주입받는다.
	
	
	@Inject
	private WebApplicationContext waCTX;

	
	// 브라우저에서 요청/응답을 처리하는 객체
	private MockMvc mockMVC;
	
	// 테스트 동작전에 필요한 설정을 세팅
	@Before
	public void setup() {
		this.mockMVC = MockMvcBuilders.webAppContextSetup(this.waCTX).build();
		logger.info("테스트 동작전 mockMVC 객체를생성(주입)");
	}
	
	
	// 컨트롤러 동작 테스트
	public void testDoA() throws Exception{
		logger.info("testDoA() 메소드 호출 !");
		
		mockMVC.perform(MockMvcRequestBuilders.get("/doA"));
	}
	
}
