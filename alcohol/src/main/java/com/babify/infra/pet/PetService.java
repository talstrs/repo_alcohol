package com.babify.infra.pet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

	@Autowired
	PetDao dao;

//	패턴 1 리스트 호출
	public List<PetDto> selectList(PetVo vo) {
		return dao.selectList(vo);
	}
	
//  패턴 2 객체 하나 호출
	public PetDto selectOne(PetDto dto) {
		return dao.selectOne(dto);
	}
	

//  insert 서비스
	public int insert(PetDto dto) {
		return dao.insert(dto);
	}
	
//  update 서비스
	public int update(PetDto dto) {
		return dao.update(dto);
	}
	
//  delete 업데이트 서비스
	public int updateDelete(PetDto dto) {
		return dao.updateDelete(dto);
	}
	
//  delete 완전삭제 서비스
	public int delete(PetDto dto) {
		return dao.delete(dto);
	}
	
	
}
