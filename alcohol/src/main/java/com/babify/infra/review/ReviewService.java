package com.babify.infra.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

//	dao를 쓸 수 있게 해 주는 어노테이션
	@Autowired
	ReviewDao dao;

	public List<ReviewDto> selectList(ReviewVo vo) {
		return dao.selectList(vo);
	}
	
	// 토탈 리턴 관련
	public int selectListCount(ReviewVo vo) throws Exception{
		return dao.selectListCount(vo);
	}

	public ReviewDto selectOne(ReviewDto dto) {
		return dao.selectOne(dto);
	}
	
	public int insert(ReviewDto dto) {
		return dao.insert(dto);
	}
	
	// 리뷰 벌점 평균 리턴
	public ReviewVo selectOneReviewAvg(ReviewVo vo) throws Exception{
		return dao.selectOneReviewAvg(vo);
	}

}