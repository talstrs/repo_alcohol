package com.babify.infra.productorders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrdersService {

	@Autowired
	ProductOrdersDao dao;
	
	public List<ProductOrdersDto> selectList(ProductOrdersVo vo) {
		return dao.selectList(vo);
	}

	public ProductOrdersDto selectOne(ProductOrdersDto dto) {
		return dao.selectOne(dto);
	}
	
//  insert 서비스
	public int insert(ProductOrdersDto dto) {
		return dao.insert(dto);
	}
	
//  update 서비스
	public int update(ProductOrdersDto dto) {
		return dao.update(dto);
	}
	
//  delete 업데이트 서비스
	public int updateDelete(ProductOrdersDto dto) {
		return dao.updateDelete(dto);
	}
	
//  delete 완전삭제 서비스
	public int delete(ProductOrdersDto dto) {
		return dao.delete(dto);
	}
	
	// 토탈 리턴 관련
	public int selectOneCount(ProductOrdersVo vo) throws Exception{
		return dao.selectListCount(vo);
	}
}
