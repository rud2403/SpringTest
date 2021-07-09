package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;
import com.mysql.fabric.xmlrpc.base.Member;

public interface MemberService {
	
	// 실행해야하는 동작을 구현 (사용자 요구사항)
	
	// 회원가입 처리 동작
	public void insertMember(MemberVO vo) throws Exception;
	
	// 로그인 체크 동작
	public MemberVO loginMember(MemberVO vo) throws Exception;
	public MemberVO loginMember(String userid, String userpw) throws Exception;

	// 회원정보 조회 동작(info)
	public MemberVO infoMember(String userid) throws Exception;
	
	// 회원정보 수정 동작
	public void updateMember(MemberVO vo) throws Exception;
	
	// 회원정보 탈퇴 동작
	public int deleteMember(MemberVO vo) throws Exception;
	
	// 전체 회원목록 확인 동작
	public List<MemberVO> memberList() throws Exception;
	
	

}
