package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	
	// http://localhost:8088/web/doA
	// 컨트롤러에서의 동작은 메소드로 구현
	@RequestMapping("doA")
	public void doA() {
		logger.info(" 출력하기 !!!!!!!!!!!!!!!!!!");
		System.out.println("@@@@@@@@@@@@@@@@@@@");
		
		logger.info("doA() 메소드 호출");
		
	}
	
	// http://localhost:8088/web/doA2
	@RequestMapping("/doA2")
	public void doA1() {
		logger.info(" daA1() 호출 !!!!!!!!!!!!");
		logger.info(" daA2.jsp 페이지로 이동");
	}
	// 컨트롤러의 동작 메소드가 리턴타입이 void인 경우
	// 매핑된 주소.jsp 페이지 호출
	// *views 폴더안에 있는 파일을 사용
	// void 방식은 매핑주소가 곧 .jsp 파일
	// 즉 주소와 페이지 이름이 같아야 할 경우 void로, 주소와 다른 이름의 페이지를 보여줄 경우 String타입으로
}
