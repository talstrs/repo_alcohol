package com.babify.common.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	
	// 포트폴리오 인덱스
	@RequestMapping(value = "/index")
	public String index() throws Exception {

		return "index/index";
	}
}
