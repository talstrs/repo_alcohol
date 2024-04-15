package com.babify.infra.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;


@Controller
public class WishlistController {
	
	@Autowired
	WishlistService service;
	
	// 위시리스트 페이지
	@RequestMapping(value = "/wishlist")
	public String productXdmListAdd(WishlistVo vo, Model model, HttpSession httpSession) throws Exception{
		
		vo.setMembersSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		
		model.addAttribute("list", service.selectList(vo));
		
		return "usr/v1/infra/wishlist";
	}
	
	// 위시리스트 추가
	
	@RequestMapping(value = "/wishlistInsert")
	public String wishlistInsert(WishlistDto dto,  HttpSession httpSession) throws Exception{

		dto.setMembersSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		service.insert(dto);
		
		return "redirect:/wishlist";
	}
	
	// 위시리스트 삭제
	@RequestMapping(value = "/wishlistUele")
	public String wishlistUele(WishlistDto dto,  HttpSession httpSession) throws Exception{
		
		dto.setMembersSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		service.updateDelete(dto);
		
		return "redirect:/wishlist";
	}
	
	
	
	



		

}