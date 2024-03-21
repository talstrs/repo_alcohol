package com.babify.infra.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.babify.common.util.UtilSearch;


@Controller
public class ProductController {
	
	@Autowired
	ProductService service;

	
	@RequestMapping(value = "/productXdmList")
	public String productXdmList(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception{
		
		UtilSearch.setSearch(vo);
		
		model.addAttribute("list", service.selectList(vo));

		
		System.out.println(vo.toString());
	
	return  "adm/v1/infra/product/productXdmList";
}
	
/* 링크 주소의 html 추가/ 데이터 받기 */
/* dto로 데이터 정상적으로 넘어오는지 확인하기: codeGroupDto dto 설정 후 sysout으로 확인 */
@RequestMapping(value = "/productXdmView")
public String productView(ProductDto dto, Model model) throws Exception{

	
	// 모델로 내용 받았을 경우 html로 넘겨주어야 함
	model.addAttribute("item", service.selectOne(dto));
	
	return "adm/v1/infra/product/productXdmView";
}

@RequestMapping(value = "/productXdmEdit")
public String productEdit(ProductDto dto, Model model) throws Exception{

	model.addAttribute("item", service.selectOne(dto));
	
	
	return "adm/v1/infra/product/productXdmEdit";
}

@RequestMapping(value = "/productXdmListAdd")
public String productXdmListAdd(ProductDto dto) throws Exception{
	
	
	return "adm/v1/infra/product/productXdmListAdd";
}

@RequestMapping(value = "/productInsert")
// 컨트롤러만 리턴 타입을 String으로 변경 가능
public String productInsert(ProductDto dto) throws Exception{

	
	service.insert(dto);
	
	return "redirect:/productXdmList";
}

@RequestMapping(value = "/productUpdt")
// 컨트롤러만 리턴 타입을 String으로 변경 가능
public String productUpdt(ProductDto dto) throws Exception{

	
	service.update(dto);
	

	return "redirect:/productXdmList";
}

@RequestMapping(value = "/productUele")
public String productUele(ProductDto dto) throws Exception{
	
	System.out.println(dto.toString());
	service.updateDelete(dto);
	
	return "redirect:/productXdmList";
}

@RequestMapping(value = "/productDele")
public String productDele(ProductDto dto) throws Exception{

	System.out.println(dto.toString());
	service.delete(dto);
	
	return "redirect:/productXdmList";
}




		

}
