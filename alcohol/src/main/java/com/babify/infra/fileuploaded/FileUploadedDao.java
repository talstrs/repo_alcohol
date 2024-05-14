package com.babify.infra.fileuploaded;

import java.util.List;

public interface FileUploadedDao {
	
	public List<FileUploadedDto> selectList(FileUploadedVo vo);
	
	public FileUploadedDto selectOne(FileUploadedDto dto);
	
	public List<FileUploadedDto> selectListWithoutPaging();
	
	public int insert(FileUploadedDto dto);
	
	public int update(FileUploadedDto dto);
	
	public int updateDelete(FileUploadedDto dto);
	
	public int delete(FileUploadedDto dto);
	
	public int selectOneCount(FileUploadedVo vo);
}
