package com.babify.infra.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;


@Controller
public class OrdersController {
	
	@Autowired
	OrdersService service;

	
	@RequestMapping(value = "/myAccount")
	public String myAccount(@ModelAttribute("vo") OrdersVo vo, Model model, HttpSession httpSession) throws Exception{
		

		
		vo.setMembersMembersSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		
		
		model.addAttribute("list", service.selectList(vo));
			



	
	
	return  "usr/v1/infra/myAccount";
}
	

		

}