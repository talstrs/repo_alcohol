package com.babify.infra.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.babify.infra.members.MembersDto;
import com.babify.infra.members.MembersService;

import jakarta.servlet.http.HttpSession;


@Controller
public class OrdersController {
	
	@Autowired
	OrdersService service;
	
	@Autowired
	MembersService membersService;
	
	
	@RequestMapping(value = "/myAccount")
	public String myAccount(@ModelAttribute("vo") OrdersVo vo, MembersDto mdto, Model model, HttpSession httpSession) throws Exception{
		
		
		mdto.setMembersSeq((String) httpSession.getAttribute("sessSeqUsr"));	
		model.addAttribute("item", membersService.selectOne(mdto));
		
		
		vo.setMembersMembersSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("list", service.selectList(vo));
			
		
		return  "usr/v1/infra/myAccount";
	}
	
	@RequestMapping(value = "/myAccountMembersEdit")
	public String myAccount(MembersDto mdto,  Model model, HttpSession httpSession) throws Exception{

		mdto.setMembersSeq((String) httpSession.getAttribute("sessSeqUsr"));
		
		
		model.addAttribute("item", membersService.selectOne(mdto));
		System.out.println(mdto.getMembersBirth());
		System.out.println(mdto.getMembersSeq());
		System.out.println("--------------------------------------");
		
		return  "usr/v1/infra/myAccountEdit";
	}
	
	@RequestMapping(value = "/myAccountMembersUpdt")
	public String membersUpdt(MembersDto mdto, HttpSession httpSession) throws Exception {
		

		
		mdto.setMembersSeq((String) httpSession.getAttribute("sessSeqUsr"));
		


		mdto.setMembersPw(encodeBcrypt((String) mdto.getMembersPw(), 10));
		
		
		membersService.update(mdto);

		return "redirect:/myAccount";
	}
	
	
	// pw 암호화
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText); 
	}

		

}