package com.babify.infra.members;

import java.util.List;


public interface MembersDao {
	
//	DAO는 인터페이스 역할로 mapper 파일과 DAO에 있는 기능 명 ex) selectList 을 맞춰주어 (아이디 값)
//  자동으로 매핑되게하는 인터페이스이다.
//  service 파일의 기능등을 명시하는 인터페이스.
//  쿼리 실행시키는 곳
	
	public List<MembersDto> selectList(MembersVo vo); //List<dto>: 여러개의 데이터를 가져올때
	public MembersDto selectOne(MembersDto dto); //dto: 하나의 데이터를 가져올때
	
	// 로그인 데이터 가져오는 dao
	public MembersDto selectOneLoginCheck(MembersDto dto);
	
	// 데이터를 추가할 때(삽입 insert)
	// insert, update, delete 구문 사용시 dao 파트는 리턴값을 int로 받아야 함
	// 건수에 대한 리턴을 받기 때문에 int를 씀
	public int insert(MembersDto dto);
	
	// 데이터를 수정할 때(수정 update)
	public int update(MembersDto dto);

	
	// 유저 정보 업데이트
	public int updateUsr(MembersDto dto);
	
	// 유저 비밀번호 업데이트
	public int updateUsrPw(MembersDto dto);
	
	// 유저 비밀번호 셀렉문 
	public MembersDto selectOnePw(MembersDto dto);
	
	// 데이터를 삭제할 때(삭제 update)
	public int updateDelete(MembersDto dto);
	
	public int delete(MembersDto dto);
	
// 토탈 개수 관련
	public int selectOneCount(MembersVo vo);
	
// 페이지네이션 관련
	public List<MembersDto> selectListWithPaging(MembersVo vo);
	
	// 로그인 id 확인
	public MembersDto selectOneLogin(MembersDto dto);
	
	// 카카오 회원등록
	public int kakaoinsert(MembersDto dto);
	
	// 카카오 기존 회원 확인
	public MembersDto kakaoSelectOne(MembersDto dto);
	
	// 카카오 회원등록
	public int naverinsert(MembersDto dto);
}
