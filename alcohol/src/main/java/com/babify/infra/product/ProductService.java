package com.babify.infra.product;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.babify.common.util.UtilDateTime;
import com.babify.infra.fileuploaded.FileUploadedDao;
import com.babify.infra.fileuploaded.FileUploadedDto;

@Service
public class ProductService {

//	dao를 쓸 수 있게 해 주는 어노테이션
	@Autowired
	ProductDao dao;
	
	@Autowired
	AmazonS3Client amazonS3Client;
	
	@Autowired
	FileUploadedDao filedao;
	
	@Value("${cloud_aws_bucket}")
	private String bucket;
	
	
	
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
	public int insert(ProductDto dto, FileUploadedDto filedto) throws Exception {
		
		
		MultipartFile[] multipartFiles = dto.getUploadFiles(); 
		
		// 파일 유무 확인하기	
		if(multipartFiles.length > 0) {
		// 인서트 주석 관련 파일업로드 db 내용 진행 후 주석 풀기
				dao.insert(dto);
			
			for(int i=0; i<multipartFiles.length; i++) {
						
				if(!multipartFiles[i].isEmpty()) {
					
					// if문 돌려서 0일때 디폴트 1, 아닐때 디폴트 0
					if(i==0) {
					
						// type = product file을 의미
						int type = 1;
						// dto 내용 변수로 받아오기
						String fileName = multipartFiles[i].getOriginalFilename();
						String uuid = UUID.randomUUID().toString();
						String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
						
						String className = dto.getClass().getSimpleName().toString().toLowerCase();
						String pathModule = className;
						String nowString = UtilDateTime.nowString();
						String pathDate = nowString.substring(0,4) + "/" + nowString.substring(5,7) + "/" + nowString.substring(8,10); 
//						String path = Constants.UPLOADED_PATH_PREFIX_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
						String path = pathModule + "/" + type + "/" + pathDate + "/";
	//					String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
					
						String uuidFileName = uuid + "." + ext;
						
				        ObjectMetadata metadata = new ObjectMetadata();
				        metadata.setContentLength(multipartFiles[i].getSize());
				        metadata.setContentType(multipartFiles[i].getContentType());
				        
				        amazonS3Client.putObject(bucket, path + uuidFileName, multipartFiles[i].getInputStream(), metadata);
						
				        String objectUrl = amazonS3Client.getUrl(bucket, path + uuidFileName).toString();
				        
				        
						// filedto에 변수값 내용 set 시키기
				        filedto.setFileUploadedType(type);
				        filedto.setFileUploadedSort(i);
				        filedto.setFileUploadedOriginalName(fileName);
				        filedto.setFileUploadedUuidName(uuid);
				        filedto.setFileUploadedExt(ext);
				        filedto.setFileUploadedSize(Integer.valueOf((int)multipartFiles[i].getSize()));
				        filedto.setFileUploadedFseq(dto.getSeq());
				        filedto.setFileUploadedPath(objectUrl);
				        filedto.setFileUploadedDefaultNy(1);
				        
				        filedao.insert(filedto);
			        
					} else {
						// type = product file을 의미
						int type = 1;
						// dto 내용 변수로 받아오기
						String fileName = multipartFiles[i].getOriginalFilename();
						String uuid = UUID.randomUUID().toString();
						String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
						
						String className = dto.getClass().getSimpleName().toString().toLowerCase();
						String pathModule = className;
						String nowString = UtilDateTime.nowString();
						String pathDate = nowString.substring(0,4) + "/" + nowString.substring(5,7) + "/" + nowString.substring(8,10); 
//						String path = Constants.UPLOADED_PATH_PREFIX_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
						String path = pathModule + "/" + type + "/" + pathDate + "/";
	//					String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
					
						String uuidFileName = uuid + "." + ext;
						
				        ObjectMetadata metadata = new ObjectMetadata();
				        metadata.setContentLength(multipartFiles[i].getSize());
				        metadata.setContentType(multipartFiles[i].getContentType());
				        
				        amazonS3Client.putObject(bucket, path + uuidFileName, multipartFiles[i].getInputStream(), metadata);
						
				        String objectUrl = amazonS3Client.getUrl(bucket, path + uuidFileName).toString();
				        
				        
						// filedto에 변수값 내용 set 시키기
				        filedto.setFileUploadedType(type);
				        filedto.setFileUploadedSort(i);
				        filedto.setFileUploadedOriginalName(fileName);
				        filedto.setFileUploadedUuidName(uuid);
				        filedto.setFileUploadedExt(ext);
				        filedto.setFileUploadedSize(Integer.valueOf((int)multipartFiles[i].getSize()));
				        filedto.setFileUploadedFseq(dto.getSeq());
				        filedto.setFileUploadedPath(objectUrl);
				        filedto.setFileUploadedDefaultNy(0);
				        
				        filedao.insert(filedto);
					}
				}
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