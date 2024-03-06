package com.babify.infra.code;

import java.util.List;



public interface CodeDao {

	public List<CodeDto> selectList();
	
//	셀렉트원 생성
	public CodeDto selectOne(CodeDto dto);
	
	public int insert(CodeDto dto);
	public int update(CodeDto dto);
	public int updateDelete(CodeDto dto);
	public int delete(CodeDto dto);
	
}
