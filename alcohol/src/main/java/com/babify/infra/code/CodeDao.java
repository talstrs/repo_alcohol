package com.babify.infra.code;

import java.util.List;



public interface CodeDao {

	public List<CodeDto> selectList(CodeVo vo);
	
	
	
//	셀렉트원 생성
	public CodeDto selectOne(CodeDto dto);
	
	public int insert(CodeDto dto);
	public int update(CodeDto dto);
	public int updateDelete(CodeDto dto);
	public int delete(CodeDto dto);
	
	// 캐시 관련
	public List<CodeDto> selectListCachedCodeArrayList();
	
	
// 토탈 개수 관련
	public int selectOneCount(CodeVo vo);
	
// 페이지네이션 관련
	public List<CodeDto> selectListWithPaging(CodeVo vo);
	
}
