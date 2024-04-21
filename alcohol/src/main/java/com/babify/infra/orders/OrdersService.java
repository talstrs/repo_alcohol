package com.babify.infra.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

//	dao를 쓸 수 있게 해 주는 어노테이션
	@Autowired
	OrdersDao dao;

	public List<OrdersDto> selectList(OrdersVo vo) {
		return dao.selectList(vo);
	}

	public OrdersDto selectOne(OrdersDto dto) {
		return dao.selectOne(dto);
	}
	
//  insert 서비스
	public int insert(OrdersDto dto) {
		return dao.insert(dto);
	}

	
}