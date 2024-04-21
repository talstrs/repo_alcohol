package com.babify.infra.orders;

import java.util.List;


public interface OrdersDao {
	
	// 오더 셀렉 리스트
	public List<OrdersDto> selectList(OrdersVo vo); //List<dto>: 여러개의 데이터를 가져올때
	// 오더 셀렉 원
	public OrdersDto selectOne(OrdersDto dto); //dto: 하나의 데이터를 가져올때
	
	public int insert(OrdersDto dto);
	
	
}