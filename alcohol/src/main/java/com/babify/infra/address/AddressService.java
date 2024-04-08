package com.babify.infra.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class AddressService {

	@Autowired
	AddressDao dao;
	

	public List<AddressDto> selectList(AddressVo vo) {
		return dao.selectList(vo);
	}
	

	public AddressDto selectOne(AddressDto dto) {
		return dao.selectOne(dto);
	}
	
	public int insert(AddressDto dto) {
		return dao.insert(dto);
	}
	
	public int update(AddressDto dto) {
		return dao.update(dto);
	}
	
	public int updateDelete(AddressDto dto) {
		return dao.updateDelete(dto);
	}
	
	

}
