package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

// @Repository : 스프링에 DAO파일을 인식한다.
//              => root-context.xml파일에서 해당객체를 bean으로 인식

@Repository
public class MemberDAOImpl implements MemberDAO {
	//DAO 객체
	
	// 디비 연결 + 자원해제 객체를 생성 => SqlSessionTemplate 객체
	// => 객체를 주입받아서 사용
	
	@Inject
	private SqlSession sqlSession;
	
	// mapper 주소
	private static final String namespace 
	   = "com.itwillbs.mapper.MemberMapper";
	

	@Override
	public String getTime() {
		System.out.println("sqlSession : "+sqlSession);
		System.out.println("DB-SQL 구문 실행");
		
		System.out.println("sqlSession 객체를 사용해서 mapper 호출 sql 실행");
		//sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		String result = sqlSession.selectOne(namespace+".getTime");
		
		return result;
	}

	
	@Override
	public void insertMember(MemberVO vo) {
		System.out.println("DAOImpl 객체-insertMember() 호출");
		System.out.println("SqlSession 객체 생성 -> mapper 접근");
		
	    // sqlSession.insert(namespace); sql 쿼리만 실행		
	    // sqlSession.insert(namespace,Object); sql쿼리 , 쿼리에 필요한 값을 전달		
		 sqlSession.insert(namespace+".insertMember", vo);
		
		 System.out.println("mapper 사용 -> Db 실행 ");
		 System.out.println("회원가입 성공 -> TEST 파일로 이동");		
	}


	@Override
	public MemberVO getMember(String userid) {
		System.out.println("DAO : getMember() 호출");
		System.out.println("DAO : 디비연결(sqlSession), mapper로 이동 sql 실행 ");
		
		MemberVO vo = sqlSession.selectOne(namespace+".getMember",userid);
		
		System.out.println("DAO : mapper 실행 완료");
		System.out.println("DAO : "+vo);
		
		return vo;
	}


	@Override
	public void updateMember(MemberVO vo) {
		System.out.println("DAO : updateMember(vo) 호출 ");
		System.out.println("DAO : 디비연결(sqlSession),mapper 호출 sql 실행");
		
		sqlSession.update(namespace+".updateMember", vo);
		
		System.out.println("DAO : mapper 실행완료 ");
	}


	@Override
	public int deleteMember(MemberVO vo) {
		System.out.println("DAO : deleteMember(vo) 호출");
		System.out.println("DAO : 디비연결(sqlSession), mapper 사용 sql 실행");
		
		int result = sqlSession.delete(namespace+".deleteMember", vo);
		
		System.out.println("DAO : 회원 삭제 완료! ");		
		
		return result;
	}


	@Override
	public MemberVO LoginMember(String loginID, String loginPW) {
		
		System.out.println("DAO : LoginMember() 호출 ");
		System.out.println("DAO : 디비연결 sqlSession, mapper 사용 sql구문 실행");
		
		// 전달되는 데이터값이 연관이 없을경우
		// Map사용하여 데이터 저장=> key,value 쌍으로 데이터 저장
		// * key값은 객체의 변수명/컬럼명과 동일하게 사용하기
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userid", loginID);
		paramMap.put("userpw", loginPW);
		
		
		return sqlSession.selectOne(namespace+".loginMember",paramMap);
	}

	

	@Override
	public List<MemberVO> getMemberList() {
		System.out.println("DAO : getMemberList() 호출");
		System.out.println("DAO : 디비연결 sqlSession, mapper이동후 sql 실행");
		
		List<MemberVO> memberList
		    = sqlSession.selectList(namespace+".getMemberList");
		
		System.out.println("DAO : "+memberList);
		
		return memberList;
	}
	
	
	
	
	
	
	
	

}
