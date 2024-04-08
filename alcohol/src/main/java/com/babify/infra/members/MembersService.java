package com.babify.infra.members;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService {

//	dao를 쓸 수 있게 해 주는 어노테이션
	@Autowired
	MembersDao dao;
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
	public List<MembersDto> selectList(MembersVo vo) {
		return dao.selectList(vo);
	}
	
//  패턴 2 객체 하나 호출
	public MembersDto selectOne(MembersDto dto) {
		return dao.selectOne(dto);
	}
	
// 로그인 객체 호출
	public MembersDto selectOneLoginCheck(MembersDto dto) {
		return dao.selectOneLoginCheck(dto);
	}

//  insert 서비스
	public int insert(MembersDto dto) {
		return dao.insert(dto);
	}
	
//  update 서비스
	public int update(MembersDto dto) {
		return dao.update(dto);
	}
	
// 유저 정보 업데이트
	public int updateUsr(MembersDto dto) {
		return dao.updateUsr(dto);
	}
	
//  delete 업데이트 서비스
	public int updateDelete(MembersDto dto) {
		return dao.updateDelete(dto);
	}
	
//  delete 완전삭제 서비스
	public int delete(MembersDto dto) {
		return dao.delete(dto);
	}
	
	public int selectOneCount(MembersVo vo) throws Exception{
		return dao.selectOneCount(vo);
	}
	
	// 페이징 처리 리스트
	public List<MembersDto> selectListWithPaging(MembersVo vo){
		return dao.selectListWithPaging(vo);
	}
	
	
}
