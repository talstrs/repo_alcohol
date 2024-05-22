package com.babify.infra.pet;

import java.util.List;


public interface PetDao {
	
	
	public List<PetDto> selectList(PetVo vo); //List<dto>: 여러개의 데이터를 가져올때
	public PetDto selectOne(PetDto dto); //dto: 하나의 데이터를 가져올때
	
	
	// 데이터를 추가할 때(삽입 insert)
	public int insert(PetDto dto);
	
	// 데이터를 수정할 때(수정 update)
	public int update(PetDto dto);
	
	// 데이터를 삭제할 때(삭제 update)
	public int updateDelete(PetDto dto);
	
	public int delete(PetDto dto);
	
	
}
