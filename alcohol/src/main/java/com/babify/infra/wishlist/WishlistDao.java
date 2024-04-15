package com.babify.infra.wishlist;

import java.util.List;


public interface WishlistDao {
	
	// 위시리스트 셀렉 리스트
	public List<WishlistDto> selectList(WishlistVo vo); //List<dto>: 여러개의 데이터를 가져올때
	
	// 위시리스트 셀렉 원
	public WishlistDto selectOne(WishlistDto dto); //dto: 하나의 데이터를 가져올때
	
	public Integer insert(WishlistDto dto);
	
	public Integer updateDelete(WishlistDto dto);
	
	
	
}