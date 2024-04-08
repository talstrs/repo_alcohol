package com.babify.infra.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AddressController {

	@Autowired
	AddressService service;
	
	// 마이어카운트 주소 추가 페이지
	@RequestMapping(value = "/myAccountAddressAdd")
	public String myAccountAddressAdd() throws Exception {
		
		
		return "usr/v1/infra/myAccountAddressAdd";
	}
	
	
	// 마이어카운트 주소 인서트
	@RequestMapping(value = "/addressInsert")
	public String addressInsert(AddressDto dto, HttpSession httpSession) throws Exception{

		dto.setMembersMembersSeqF((String) httpSession.getAttribute("sessSeqUsr"));	
		
		service.insert(dto);
		
		return "redirect:/myAccount";
	}
	
	
	// 마이어카운트 주소 수정 페이지
	@RequestMapping(value = "/myAccountAddressEdit")
	public String myAccountAddressEdit(AddressDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "usr/v1/infra/myAccountAddressEdit";
	}
	
	// 마이어카운트 업데이트
	@RequestMapping(value = "/addressUpdt")
	public String addressUpdt(AddressDto dto) throws Exception{
		
		service.update(dto);
		
		return "redirect:/myAccount";
	}
	

	

	

}
