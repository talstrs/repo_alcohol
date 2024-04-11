package com.babify.infra.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;


@Controller
public class ReviewController {
	
	@Autowired
	ReviewService service;
	
	@RequestMapping(value = "/reviewInsert")
	public String reviewInsert(ReviewDto dto, HttpSession httpSession) throws Exception{
		
		dto.setReviewMembersSeq((String)httpSession.getAttribute("sessSeqUsr"));
		
		service.insert(dto);
		
		return "redirect:/productUsrList";
	}


		

}