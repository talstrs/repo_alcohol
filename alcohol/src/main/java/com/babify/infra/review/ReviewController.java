package com.babify.infra.review;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babify.infra.product.ProductDto;
import com.babify.infra.product.ProductService;

import jakarta.servlet.http.HttpSession;


@Controller
public class ReviewController {
	
	@Autowired
	ReviewService service;
	
	@Autowired
	ProductService productService;
	
	
	@ResponseBody
	@RequestMapping(value = "/reviewInsert")
	public Map<String, Object> reviewInsert(ReviewDto dto, ProductDto pdto, HttpSession httpSession) throws Exception{
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		
		dto.setReviewMembersSeq((String)httpSession.getAttribute("sessSeqUsr"));
		
		ProductDto dtoCheck = productService.selectOne(pdto);
		

		if(dtoCheck != null) {
			
			
			service.insert(dto);
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "fail");
		}
		
		service.insert(dto);
		
		return returnMap;
	}


		

}