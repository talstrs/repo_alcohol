package com.babify.infra.product;

import java.util.List;


public interface ProductDao {
	
//	DAO는 인터페이스 역할로 mapper 파일과 DAO에 있는 기능 명 ex) selectList 을 맞춰주어 (아이디 값)
//  자동으로 매핑되게하는 인터페이스이다.
//  service 파일의 기능등을 명시하는 인터페이스.
//  쿼리 실행시키는 곳
	
	// 관리자 셀렉 리스트
	public List<ProductDto> selectList(ProductVo vo); //List<dto>: 여러개의 데이터를 가져올때
	// 사용자 셀렉 리스트
	public List<ProductDto> selectListUsr(ProductVo vo); //List<dto>: 여러개의 데이터를 가져올때
	
	// 사용자 인덱스 베스트 셀렉 리스트
	public List<ProductDto> selectListUsrIndexBest(ProductVo vo);
	
	// 사용자 인덱스 뉴 셀렉 리스트
	public List<ProductDto> selectListUsrIndexNew(ProductVo vo);
	
	// 사용자 품목 연관상품
	public List<ProductDto> selectListRelated(ProductVo vo);
	
	
	public ProductDto selectOne(ProductDto dto); //dto: 하나의 데이터를 가져올때
	
	// 데이터를 추가할 때(삽입 insert)
	// insert, update, delete 구문 사용시 dao 파트는 리턴값을 int로 받아야 함
	// 건수에 대한 리턴을 받기 때문에 int를 씀
	public int insert(ProductDto dto);
	
	// 데이터를 수장할 때(수정 update)
	public int update(ProductDto dto);
	
	// 데이터를 삭제할 때(삭제 update)
	public int updateDelete(ProductDto dto);
	
	public int delete(ProductDto dto);

// 토탈 개수 관련 (관리자)
	public int selectOneCount(ProductVo vo);

// 토탈 개수 관련 (사용자)
	public int selectOneCountUsr(ProductVo vo);
	
// 페이지네이션 관련
	public List<ProductDto> selectListWithPaging(ProductVo vo);
	
}