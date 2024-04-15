package com.babify.infra.wishlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {

//	dao를 쓸 수 있게 해 주는 어노테이션
	@Autowired
	WishlistDao dao;

	public List<WishlistDto> selectList(WishlistVo vo) {
		return dao.selectList(vo);
	}
	
	public WishlistDto selectOne(WishlistDto dto) {
		return dao.selectOne(dto);
	}
	
	public int insert(WishlistDto dto) {
		return dao.insert(dto);
	}
	
	public int updateDelete(WishlistDto dto) {
		return dao.updateDelete(dto);
	}


}