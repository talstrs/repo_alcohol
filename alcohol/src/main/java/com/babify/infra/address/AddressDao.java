package com.babify.infra.address;

import java.util.List;

public interface AddressDao {

	public List<AddressDto> selectList(AddressVo vo);
	
	public AddressDto selectOne(AddressDto dto);
	
	public int insert(AddressDto dto);
	public int update(AddressDto dto);
	public int updateDelete(AddressDto dto);
		
}
