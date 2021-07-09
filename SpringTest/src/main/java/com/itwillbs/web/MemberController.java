package com.itwillbs.web;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger 
	  = LoggerFactory.getLogger(MemberController.class);
	
	//서비스 객체를 주입
	@Inject
	private MemberService service;
	
	// 회원가입 동작
	// 1) 회원정보 입력(get)
	// http://localhost:8088/web/insert (x)
	// http://localhost:8088/web/member/insert (o)
	//@RequestMapping("/insert")
	@RequestMapping(value = "/insert",method = RequestMethod.GET)
	public void insertMemberGET() throws Exception {
		logger.info("insertMemberGET() 호출");
		
		logger.info("주소에 해당하는 view 페이지 연결");
		logger.info("/views/member/insert.jsp 이동");
		
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public String insertMemberPOST(MemberVO vo,
			@ModelAttribute("msg") String msg) throws Exception {
		// 메서드의 매개변수로 MemberVO 객체를 생성하면
		// 자동으로(스프링MVC) 전달되는 파라미터의 값을 저장해준다.
		
		logger.info("insertMemberPOST() 호출");
		// 전달된 정보 저장
		logger.info("vo : "+vo);
		logger.info("msg :" +msg);
		
		// 전달받은 정보를 DB에 저장-> DAO 객체 생성(x)
		//  => 서비스 객체 호출 => DAO 호출 => mapper 호출 => DB 실행
		service.insertMember(vo);
		
		logger.info("회원 가입 성공!");
		
		// 페이지 이동(login 페이지로 리다이렉트)
		return "redirect:/member/login";		
	}
	
	// http://localhost:8088/web/member/login
	// 로그인페이지(get)
	@RequestMapping(value = "/member/login",method = RequestMethod.GET)
	public String loginGET() throws Exception{
		logger.info("C : loginGET() 페이지 호출");
		logger.info("C : login view 페이지로 이동");
		
		return "/member/loginForm";
	}
	
	// 로그인 처리 동작(post)
	@RequestMapping(value = "/member/login",method = RequestMethod.POST)
	public String loginPOST(MemberVO vo,HttpSession session/* @ModelAttribute("userid") String userid */) throws Exception{
		logger.info("C: loginPOST() 호출! ");
		
		// DB에 회원정보가 있는지 체크 
		// O -> 메인페이지, 로그인세션 생성
		// X -> 다시 로그인페이지로 이동
		
		// 서비스 동작 -> DAO -> (MyBatis)mapper -> DB
		logger.info("C : 서비스-loginMember() 호출시도 ");
		logger.info(vo.getUserid()+"@@@@@"+vo.getUserpw());
		MemberVO loginVO = service.loginMember(vo);
		//service.loginMember(vo.getUserid(), vo.getUserpw());
		
		if(loginVO == null) {
			// 비회원/비밀번호 오류
			// 다시 로그인페이지로 이동
			return "redirect:/member/login";			
		}
		
		// 회원
		// 로그인 세션처리 (jsp 뷰 페이지에서 세션객체 전달받아서 처리)
		session.setAttribute("id", loginVO.getUserid());
		
		// 페이지 이동
		return "redirect:/member/main";
	}
	
	
	// http://localhost:8088/web/member/main
	// 메인페이지(정보조회-get)
	@RequestMapping(value = "/main",method = RequestMethod.GET)
	public void mainGET() throws Exception{
		logger.info("C : mainGET() 호출 -> /member/main.jsp 이동");
		
	}
	
	
	// 로그아웃 기능(get)
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logoutGET(HttpSession session) throws Exception{
		
		logger.info("C : logoutGET() 호출 -> /member/main.jsp 페이지 이동");
		
		// 세션정보 초기화
		session.invalidate();		
		
		// 페이지 이동
		return "redirect:/member/main";
	}
	
	// http://localhost:8088/web/member/info
	// 회원정보 조회(info)-get
	@RequestMapping(value = "/info",method=RequestMethod.GET)
	public void infoGET(HttpSession session,Model model) throws Exception{
		
		logger.info("C : infoGET() 호출");
		// 세션 영역에 있는 ID(로그인정보) 가져오기
		String id = (String)session.getAttribute("id");	
		
		// DB에 회원정보를 가져오는 동작
		MemberVO infoVO = service.infoMember(id);
		
		logger.info("C : @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		logger.info("C: "+infoVO);
		
		// DB 회원정보를 view페이지로 이동
		// DB정보를 model 객체에 저장
		model.addAttribute("infoVO", infoVO);
		
		logger.info(" 페이지 이동 /views/member/info.jsp ");
		
	}
	
	// http://localhost:8088/web/member/update
	// 회원정보 수정(get)
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public String updateGET(HttpSession session,Model model) throws Exception{

		logger.info("C : updateGET() 호출");
		
		// 로그인정보(세션)을 사용하여 DB정보를 조회
		String id = (String) session.getAttribute("id");
		
	    MemberVO updateVO = service.infoMember(id);
		
		// model 객체에 저장
		model.addAttribute("updateVO", updateVO);
		
		// 페이지 이동  /views/member/updateForm.jsp
		return "/member/updateForm";
	}
	
	// 회원정보 수정(post)
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updatePOST(MemberVO vo) throws Exception{
		
		logger.info(" C : updatePOST() 호출 ");
		
		// 전달된 수정할 정보 저장
		// DB이동을 위한 서비스객체 주입
		service.updateMember(vo);
		
		// 페이지 이동(main.jsp)
		return "redirect: /web/member/main";
	}
	
	
	// http://localhost:8088/web/member/delete
	// 회원 탈퇴(delete) 동작
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String deleteGET() throws Exception{
		logger.info("C: deleteGET() 호출");
		logger.info("C: /member/deleteForm.jsp 페이지로 이동");
   		
	   return "/member/deleteForm";	
	}
	
	// 회원 탈퇴(delete) 처리동작
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public String deletePOST(MemberVO vo, HttpSession session) throws Exception{
		
		logger.info("C : deletePOST()  호출 ");
		
		// 삭제할 회원정보를 전달받기(파라미터)
		logger.info("C : 삭제 정보 "+vo);

		// DB 데이터 삭제처리 => 서비스 동작을 호출
		int result = service.deleteMember(vo);
		
		if(result == 0) {
			logger.info("C : 삭제 실패");
			return "redirect:/member/delete";
		}
		// 세션값 초기화		
		session.invalidate();
		// 메인페이지 이동
		return "redirect:/member/main";
	}
	
	
	// 관리자 기능-회원 목록 확인
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public void listGET(Model model) throws Exception{
		
		logger.info("C : listGET() 호출");
		
		// 서비스 동작 호출 -> 회원 목록 조회
		List<MemberVO> memberList = service.memberList();
		
		model.addAttribute("memberList", memberList);
		
		// 페이지 이동(/member/list.jsp)		
	}
	
	
	
	
	
	

}
