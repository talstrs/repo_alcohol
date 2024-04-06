package com.babify.infra.address;

import java.util.List;

public interface AddressDao {

	public List<AddressDto> selectList(AddressVo vo);
	
	public AddressDto selectOne(AddressDto dto);
		
}
