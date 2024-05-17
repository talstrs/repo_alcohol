package com.babify.infra.fileuploaded;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadedService {

	@Autowired
	FileUploadedDao dao;
	
	public List<FileUploadedDto> selectList(FileUploadedVo vo) {
		return dao.selectList(vo);
	}
	
//  패턴 2 객체 하나 호출
	public FileUploadedDto selectOne(FileUploadedDto dto) {
		return dao.selectOne(dto);
	}

//  insert 서비스
	public int insert(FileUploadedDto dto) {
		return dao.insert(dto);
	}
	
//  update 서비스
	public int update(FileUploadedDto dto) {
		return dao.update(dto);
	}
	
//  delete 업데이트 서비스
	public int updateDelete(FileUploadedDto dto) {
		return dao.updateDelete(dto);
	}
	
//  delete 완전삭제 서비스
	public int delete(FileUploadedDto dto) {
		return dao.delete(dto);
	}
	
	
	// 토탈 리턴 관련
	public int selectOneCount(FileUploadedVo vo) throws Exception{
		return dao.selectOneCount(vo);
	}
	
}
