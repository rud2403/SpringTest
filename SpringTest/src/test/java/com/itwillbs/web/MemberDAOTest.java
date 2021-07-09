package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.persistence.MemberDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {
	
	
	// DAO 객체 생성 (의존관계)
	// private MemberDAO mDAO = new MemberDAOImpl(); (강한결합x)

	// 의존주입
	@Inject
	private MemberDAO mDAO;
	
	
	//DAO 객체 주입 확인
	@Test
	public void testDAO() {
		System.out.println("DAO : "+mDAO);
	}
	
	// DAO 객체 메서드 호출(시간정보 가져오는 메서드)
	//@Test
	public void testGetTime() {
		System.out.println("Model-Action페이지");
		
		System.out.println("시간정보 " + mDAO.getTime() );
		
		System.out.println("-----------------------------------------");		
	}
	
	// DAO 객체안에 회원가입하는 메서드호출
	//@Test
	public void testInsertMember() {
		System.out.println(" 회원가입 메서드 동작 ");
		System.out.println(" DAO-insertMember() 메서드 호출 ");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("itwill2");
		vo.setUserpw("1234");
		vo.setUsername("관리자");
		vo.setUseremail("admin@itwillbs.co.kr");
		
		mDAO.insertMember(vo);
		
		System.out.println("TEST 회원가입 성공!");			
	}
	
	
	// 특정 회원에 해당하는 정보를 확인
	//@Test
	public void testGetMember() {
		String userid="admin";
		
		// DAO 객체를 생성 -> 주입
		System.out.println("TEST : DAO 객체 주입, getMember()호출 ");
		
		MemberVO vo = mDAO.getMember(userid);
		
		System.out.println("TEST : "+vo);		
		
	}
	
	// 회원 정보 수정
	//@Test
	public void testUpdateMember() {
		MemberVO updateVO = new MemberVO();
		
		updateVO.setUserid("admin1");
		updateVO.setUserpw("1234");
		updateVO.setUsername("수정이름");
		updateVO.setUseremail("수정이메일@itwill.com");
		
		// DAO 객체를 주입
		mDAO.updateMember(updateVO);
		
		System.out.println("TEST : 회원정보 수정 완료");
		
	}
	
	// 회원 정보 삭제
	//@Test
	public void testDeleteMember() {
		MemberVO delMember = new MemberVO();
		delMember.setUserid("admin1");
		delMember.setUserpw("1234");
		
		// DAO 객체를 주입
		mDAO.deleteMember(delMember);
		
		System.out.println("TEST : 회원정보 삭제 완료");
		
	}
	
	// 로그인 처리
	//@Test
	public void testLogin() {
		
		String loginID = "admin";
		String loginPW = "1234";
		// id,pw에 해당하는 회원정보가 있을 경우 - 로그인 성공
		//              "         없을 경우 - 로그인 실패
		
		MemberVO loginVO = mDAO.LoginMember(loginID,loginPW);
		
		if(loginVO != null) {
			System.out.println("TEST : 로그인 성공 !!!!!!!!");
			
		}else {
			System.out.println("TEST : 로그인 실패 @@@@@@@@@");
		}
		
	}
	
	// 회원 전체 목록 조회
	@Test
	public void testMemberList() {
		System.out.println("TEST : 회원 전체 목록 조회 ");
		
		// DAO 주입
		List<MemberVO> memberList = mDAO.getMemberList();
		
		System.out.println("TEST : " + memberList);
	}
	

}
