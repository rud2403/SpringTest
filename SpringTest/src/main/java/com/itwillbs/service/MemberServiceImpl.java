package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;
import com.mysql.fabric.xmlrpc.base.Member;

// @Service : 외부에서 해당서비스를 호출시 처리할 수 있도록 등록
//            => root-context.xml 파일에서 BEAN 형태로 인식 

@Service
public class MemberServiceImpl implements MemberService{

	//DAO 객체 생성
	@Inject
	private MemberDAO mdao;
	
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		System.out.println("S : 컨트롤러에서 정보를 받아서 제공");
		System.out.println("S : 회원가입 동작");
		
		mdao.insertMember(vo);

		System.out.println("S : 회원가입 처리 완료");
		System.out.println("S : 컨트롤러로 이동");
				
	}

	@Override
	public MemberVO loginMember(MemberVO vo) throws Exception {
		
		System.out.println("S : loginMember(vo) 호출 ");
		System.out.println("S : DAO-LoginMember(id,pw) 호출시도");
		
		// DAO 주입
		MemberVO loginVO = mdao.LoginMember(vo.getUserid(), vo.getUserpw());		
		
		System.out.println("S : 로그인정보 "+loginVO);
		
		return loginVO;
	}

	@Override
	public MemberVO loginMember(String userid, String userpw) throws Exception {

		System.out.println("S : loginMember(vo) 호출 ");
		System.out.println("S : DAO-LoginMember(id,pw) 호출시도");
		
		// DAO 주입
		return mdao.LoginMember(userid,userpw);
	}

	
	
	@Override
	public MemberVO infoMember(String userid) throws Exception {
		System.out.println("S : infoMember(id) 호출");
		System.out.println("S : DAO-getMember(id) 호출");
		
		MemberVO infoVO = mdao.getMember(userid);
		System.out.println("S : "+infoVO);
		
		return infoVO;
	}

	@Override
	public void updateMember(MemberVO vo) throws Exception {
		
		System.out.println("S : updateMember(MemberVO vo) 호출 ");
		
		mdao.updateMember(vo);
		
		System.out.println("S : 회원 정보 수정완료!");	
	}

	@Override
	public int deleteMember(MemberVO vo) throws Exception {
		System.out.println("S : deleteMember() 호출");
		
		int result = mdao.deleteMember(vo);
		
		System.out.println("S : 회원 탈퇴 처리 완료! "+result);
		
		return result;
	}

	@Override
	public List<MemberVO> memberList() throws Exception {

		System.out.println("S : memberList() 호출 ");
		
		List<MemberVO> memberList = mdao.getMemberList();
		
		
		return memberList;
	}
	
	
	
	

}
