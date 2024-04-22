package com.babify.infra.productorders;

import java.util.List;


public interface ProductOrdersDao {
	
	// 리뷰 셀렉 리스트
	public List<ProductOrdersDto> selectList(ProductOrdersVo vo); //List<dto>: 여러개의 데이터를 가져올때
	// 리뷰 셀렉 리스트 카운트
	public int selectListCount(ProductOrdersVo vo);
	
	// 리뷰 셀렉 원
	public ProductOrdersDto selectOne(ProductOrdersDto dto); //dto: 하나의 데이터를 가져올때
	
	public Integer insert(ProductOrdersDto dto);
	
	// 데이터를 수장할 때(수정 update)
	public int update(ProductOrdersDto dto);
	
	// 데이터를 삭제할 때(삭제 update)
	public int updateDelete(ProductOrdersDto dto);
	
	public int delete(ProductOrdersDto dto);
	
	
	
	
	
}