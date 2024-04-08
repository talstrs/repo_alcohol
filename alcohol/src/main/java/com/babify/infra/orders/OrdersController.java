package com.babify.infra.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.babify.infra.address.AddressDto;
import com.babify.infra.address.AddressService;
import com.babify.infra.address.AddressVo;
import com.babify.infra.members.MembersDto;
import com.babify.infra.members.MembersService;

import jakarta.servlet.http.HttpSession;


@Controller
public class OrdersController {
	
	@Autowired
	OrdersService service;
	
	@Autowired
	MembersService membersService;
	

	@Autowired
	AddressService addressService;
	
	// 마이페이지 페이지
	@RequestMapping(value = "/myAccount")
	public String myAccount(@ModelAttribute("vo") OrdersVo vo, AddressVo advo, MembersDto mdto, Model model, HttpSession httpSession) throws Exception{
		
		
		mdto.setMembersSeq((String) httpSession.getAttribute("sessSeqUsr"));	
		model.addAttribute("item", membersService.selectOne(mdto));

		advo.setMembersMembersSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("listAddress", addressService.selectList(advo));
		
		vo.setMembersMembersSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("list", service.selectList(vo));
		

			
		
		return  "usr/v1/infra/myAccount";
	}
	
	// 개인정보 수정 페이지
	@RequestMapping(value = "/myAccountMembersEdit")
	public String myAccountMembersEdit(MembersDto mdto,  Model model, HttpSession httpSession) throws Exception{

		mdto.setMembersSeq((String) httpSession.getAttribute("sessSeqUsr"));
		
		
		model.addAttribute("item", membersService.selectOne(mdto));
		
		return  "usr/v1/infra/myAccountEdit";
	}
	
	// 개인정보 수정
	@RequestMapping(value = "/myAccountMembersUpdt")
	public String membersUpdt(MembersDto mdto, HttpSession httpSession) throws Exception {
		

		
		mdto.setMembersSeq((String) httpSession.getAttribute("sessSeqUsr"));
		

//		mdto.setMembersPw(encodeBcrypt((String) mdto.getMembersPw(), 10));
		
		
		membersService.updateUsr(mdto);

		return "redirect:/myAccount";
	}
	
	// 개인정보 수정(비밀번호) 페이지
	@RequestMapping(value = "/myAccountPwEdit")
	public String myAccountPwEdit(MembersDto mdto,  Model model, HttpSession httpSession) throws Exception{

		mdto.setMembersSeq((String) httpSession.getAttribute("sessSeqUsr"));
		
		
		model.addAttribute("item", membersService.selectOne(mdto));
		
		return  "usr/v1/infra/myAccountPwEdit";
	}
	
	
	// pw 암호화
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText); 
	}
	
	
	// 오더 상세페이지 페이지 myAccountOrderView
	@RequestMapping(value = "/myAccountOrderView")
	public String myAccountOrderView(OrdersDto dto, MembersDto mdto, AddressDto addto,  Model model, HttpSession httpSession) throws Exception{
		// 하나의 매퍼로 진행하기!!!! ㅠㅠㅠㅠ
		mdto.setMembersSeq((String) httpSession.getAttribute("sessSeqUsr"));
		
		model.addAttribute("itemMembers", membersService.selectOne(mdto));
		
		model.addAttribute("item", service.selectOne(dto));
		
		addto.setAddressSeq((String) dto.getOrdersAddressSeq());
		System.out.println(dto.getOrdersAddressSeq());
		System.out.println("addto.getAddressSeq(): " + addto.getAddressSeq());
		System.out.println("---------------------------");
		System.out.println("---------------------------");
		System.out.println("---------------------------");
		model.addAttribute("itemAddress", addressService.selectOne(addto));
		
		return  "usr/v1/infra/myAccountOrderView";
	}
	

		

}