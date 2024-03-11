package com.babify.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {

//	dao를 쓸 수 있게 해 주는 어노테이션
	@Autowired
	CodeGroupDao dao;
//	CodeGroupDao CodeGroupDao;
//	@Autowired 와 CodeGroupDao dao;의 이미는 아래와 같다
//	CodeGroupDao dao = new CodeGroupDao();

//	패턴 1
//	public List<CodeGroupDto> selectList(){
//		
//		List<CodeGroupDto> list = dao.selectList();
//		
//		return list;
//	}
// 	서비스는 논리 로직
//	패턴 2 리스트 호출
	public List<CodeGroupDto> selectList(CodeGroupVo vo) {
		return dao.selectList(vo);
	}
	
//  패턴 2 객체 하나 호출
	public CodeGroupDto selectOne(CodeGroupDto dto) {
		return dao.selectOne(dto);
	}

//  insert 서비스
	public int insert(CodeGroupDto dto) {
		return dao.insert(dto);
	}
	
//  update 서비스
	public int update(CodeGroupDto dto) {
		return dao.update(dto);
	}
	
//  delete 업데이트 서비스
	public int updateDelete(CodeGroupDto dto) {
		return dao.updateDelete(dto);
	}
	
//  delete 완전삭제 서비스
	public int delete(CodeGroupDto dto) {
		return dao.delete(dto);
	}
}
