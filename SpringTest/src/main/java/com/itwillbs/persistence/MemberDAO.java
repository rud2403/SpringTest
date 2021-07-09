package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	// DB를 사용하는 기능구현(추상메서드)
	
	// DB서버의 시간정보를 가져오는 기능
	public String getTime();
	
	// 회원정보 가입 기능
	public void insertMember(MemberVO vo);
	
	// 특정 회원정보 가져오는(조회) 기능
	public MemberVO getMember(String userid);
	
	// 회원정보 수정 기능
	public void updateMember(MemberVO vo);
	
	// 회원정보 삭제 기능
	// public void deleteMember(MemberVO vo);
	public int deleteMember(MemberVO vo);

	
	
	// 회원 로그인 체크 기능
	public MemberVO LoginMember(String loginID,String loginPW);
	
	
	// 회원 전체 목록 조회 기능
	public List<MemberVO> getMemberList();
	

}
