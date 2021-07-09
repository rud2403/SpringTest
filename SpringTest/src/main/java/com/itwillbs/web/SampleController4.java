package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

	private static final Logger logger = LoggerFactory.getLogger(sampleController3.class);
	
	// http://localhost:8088/web/doD
	// http://localhost:8088/web/doD?msg=testData
	@RequestMapping("/doD")
	public String doD(RedirectAttributes rttr) {
		
		logger.info("doD() 호출");
		
		rttr.addFlashAttribute("msg", "1회성 데이터 전달하기 ! ");
		
		// return "/doE"; doE.jsp 뷰 페이지 연결
		// return "forward:/doE";
		
		return "redirect:/doE";
		// doD페이지로 갔는데 doE로 이동되는 리다이렉트
	}
	
	// http://localhost:8088/web/doE
	@RequestMapping("/doE")
	public void doE(@ModelAttribute("msg") String msg) {
		logger.info("doE() 호출");
		logger.info("msg : " + msg);
		
	}
	
	// *RedirectAttributes 객체 : 리다이렉트 페이지 이동 시 사용가능한 객체
	// 페이지간에 데이터 전달가능 ( Model 기능유사 )
	
	// rttr.addAttribute(); : URI에 표시O, 페이지 새로고침해도 데이터가 있음
	
	// rttr.addFlashAttribute(); : URI에 표시X, 새로고침 시 데이터 사라짐 (1회성)
	
	
	
}
