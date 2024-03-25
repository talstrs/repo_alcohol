package com.babify.infra.codegroup;

import java.util.List;


public interface CodeGroupDao {
	
//	DAO는 인터페이스 역할로 mapper 파일과 DAO에 있는 기능 명 ex) selectList 을 맞춰주어 (아이디 값)
//  자동으로 매핑되게하는 인터페이스이다.
//  service 파일의 기능등을 명시하는 인터페이스.
//  쿼리 실행시키는 곳
	
	public List<CodeGroupDto> selectList(CodeGroupVo vo); //List<dto>: 여러개의 데이터를 가져올때
	public CodeGroupDto selectOne(CodeGroupDto dto); //dto: 하나의 데이터를 가져올때
	
	public List<CodeGroupDto> selectListWithoutPaging();
	
	// 데이터를 추가할 때(삽입 insert)
	// insert, update, delete 구문 사용시 dao 파트는 리턴값을 int로 받아야 함
	// 건수에 대한 리턴을 받기 때문에 int를 씀
	public int insert(CodeGroupDto dto);
	
	// 데이터를 수장할 때(수정 update)
	public int update(CodeGroupDto dto);
	
	// 데이터를 삭제할 때(삭제 update)
	public int updateDelete(CodeGroupDto dto);
	
	public int delete(CodeGroupDto dto);
	
}
