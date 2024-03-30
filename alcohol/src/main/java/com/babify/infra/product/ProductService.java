package com.babify.infra.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
// 	서비스는 논리 로직
//	패턴 2 리스트 호출
	public List<ProductDto> selectList(ProductVo vo) {
		return dao.selectList(vo);
	}
	
//  패턴 2 객체 하나 호출
	public ProductDto selectOne(ProductDto dto) {
		return dao.selectOne(dto);
	}

//  insert 서비스
	public int insert(ProductDto dto) {
		return dao.insert(dto);
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
	
	// 토탈 리턴 관련
	public int selectOneCount(ProductVo vo) throws Exception{
		return dao.selectOneCount(vo);
	}
	
	// 페이징 처리 리스트
	public List<ProductDto> selectListWithPaging(ProductVo vo){
		return dao.selectListWithPaging(vo);
	}
}