package com.babify.infra.review;

import java.util.List;


public interface ReviewDao {
	
	// 오더 셀렉 리스트
	public List<ReviewDto> selectList(ReviewVo vo); //List<dto>: 여러개의 데이터를 가져올때
	// 오더 셀렉 리스트 카운트
	public int selectListCount(ReviewVo vo);
	
	// 오더 셀렉 원
	public ReviewDto selectOne(ReviewDto dto); //dto: 하나의 데이터를 가져올때
	
	public int insert(ReviewDto dto);
	
	
	
}