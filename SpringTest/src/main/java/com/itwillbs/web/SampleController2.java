package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	// String 타입으로 리턴하는 동작
	@RequestMapping(value = "/doB")
	public String doB() {
		
		logger.info("doB() 메소드 호출");
		
		return "";
	}
	
	// http://localhost:8088/web/doB1 호출되는 doB.jsp페이지 생성
	
	// String 타입으로 리턴하는 동작
	@RequestMapping("/doB1") // 주소호출
	public String doB1() {
		
		logger.info("doB1() 메소드 호출");
		logger.info("String 타입 리턴 -> 리턴결과.jsp 페이지 호출");
		
		return "doB"; // .jsp 이동
	}
	
	// String 타입으로 리턴하는 동작
	// http://localhost:8088/web/doB2?msg=test&txt=test1
	@RequestMapping("/doB2")
	public String doB2(@ModelAttribute("msg") String msg, @ModelAttribute("txt") String txt) {
		
		
		logger.info("doB2() 메소드 호출");
		logger.info("result.jsp 페이지 이동");
		logger.info("view페이지로 이동 할 정보" + msg);
		
		return "result";
	}
}
