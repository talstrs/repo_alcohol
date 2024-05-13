package com.babify.infra.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class ProductService {

//	dao를 쓸 수 있게 해 주는 어노테이션
	@Autowired
	ProductDao dao;
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
	
	@Autowired
	AmazonS3Client amazonS3Client;
	
	@Value("${cloud_aws_bucket}")
    private String bucket;
	
	
// 	서비스는 논리 로직
//	패턴 2 리스트 호출(관리자)
	public List<ProductDto> selectList(ProductVo vo) {
		return dao.selectList(vo);
	}

//	패턴 2 리스트 호출(사용자)
	public List<ProductDto> selectListUsr(ProductVo vo) {
		return dao.selectListUsr(vo);
	}
	
//	패턴 2 리스트 호출(사용자 인덱스 베스트)
	public List<ProductDto> selectListUsrIndexBest(ProductVo vo) {
		return dao.selectListUsrIndexBest(vo);
	}
	
//	패턴 2 리스트 호출(사용자 인덱스 뉴)
	public List<ProductDto> selectListUsrIndexNew(ProductVo vo) {
		return dao.selectListUsrIndexNew(vo);
	}
	
//	패턴 2 리스트 호출(사용자 품목 연관상품)
	public List<ProductDto> selectListRelated(ProductVo vo) {
		return dao.selectListRelated(vo);
	}
	
//  패턴 2 객체 하나 호출
	public ProductDto selectOne(ProductDto dto) {
		return dao.selectOne(dto);
	}

//  insert 서비스
	public int insert(ProductDto dto) throws Exception {
		
	// 인서트 주석 관련 파일업로드 db 내용 진행 후 주석 풀기
//		dao.insert(dto);
		
		for(MultipartFile multipartFile : dto.getUploadFiles()) {
			
			if(!multipartFile.isEmpty()) {
				System.out.println("multipartFile.getOriginalFilename() : " + multipartFile.getOriginalFilename());
				
		        ObjectMetadata metadata = new ObjectMetadata();
		        metadata.setContentLength(multipartFile.getSize());
		        metadata.setContentType(multipartFile.getContentType());
		        
		        amazonS3Client.putObject(bucket, multipartFile.getOriginalFilename(), multipartFile.getInputStream(), metadata);
				
		        String objectUrl = amazonS3Client.getUrl(bucket, multipartFile.getOriginalFilename()).toString();
		        
		        System.out.println(objectUrl);
				
			}
		}
		
		return 0;
	}
	
//  update 서비스
	public int update(ProductDto dto) {
		return dao.update(dto);
	}
	
//  delete 업데이트 서비스
	public int updateDelete(ProductDto dto) {
		return dao.updateDelete(dto);
	}
	
//  delete 완전삭제 서비스
	public int delete(ProductDto dto) {
		return dao.delete(dto);
	}
	
	// 토탈 리턴 관련 (관리자)
	public int selectOneCount(ProductVo vo) throws Exception{
		return dao.selectOneCount(vo);
	}
	
	// 토탈 리턴 관련 (사용자)
	public int selectOneCountUsr(ProductVo vo) throws Exception{
		return dao.selectOneCountUsr(vo);
	}
	
	// 페이징 처리 리스트
	public List<ProductDto> selectListWithPaging(ProductVo vo){
		return dao.selectListWithPaging(vo);
	}
}