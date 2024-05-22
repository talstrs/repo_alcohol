package com.babify.infra.product;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.babify.common.util.UtilSearch;
import com.babify.infra.fileuploaded.FileUploadedDto;
import com.babify.infra.fileuploaded.FileUploadedService;
import com.babify.infra.fileuploaded.FileUploadedVo;
import com.babify.infra.pet.PetDto;
import com.babify.infra.review.ReviewDto;
import com.babify.infra.review.ReviewService;
import com.babify.infra.review.ReviewVo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@Autowired
	ReviewService reviewService;

	@Autowired
	FileUploadedService fileService;
	
	

	
	@RequestMapping(value = "/productXdmList")
	public String productXdmList(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception{
		
		UtilSearch.setSearch(vo);
		
		// 페이징 관련 if 함수 후 모델 객체 불러오기
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if(vo.getTotalRows() > 0) {
			
			model.addAttribute("list", service.selectList(vo));
		}

	
	
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
public String productXdmListAdd() throws Exception{
	
	
	return "adm/v1/infra/product/productXdmListAdd";
}

@RequestMapping(value = "/productInsert")
public String productInsert(ProductDto dto, FileUploadedDto filedto) throws Exception{
	
	
	service.insert(dto, filedto);
	
	
	return "redirect:/productXdmList";
}

@RequestMapping(value = "/productUpdt")
public String productUpdt(ProductDto dto) throws Exception{

	service.update(dto);
	

	return "redirect:/productXdmList";
}

@RequestMapping(value = "/productUele")
public String productUele(ProductDto dto) throws Exception{
	
	service.updateDelete(dto);
	
	return "redirect:/productXdmList";
}


@RequestMapping(value = "/productDele")
public String productDele(ProductDto dto) throws Exception{

	service.delete(dto);
	
	return "redirect:/productXdmList";
}

//멀티 체크박스 삭제
@RequestMapping(value = "/productMultiUele")
public String productMultiUele(ProductDto dto) throws Exception{
	String[] checkboxSeqArray = dto.getCheckboxSeqArray();
	for(String checkboxSeq : checkboxSeqArray) {
		dto.setProductSeq(checkboxSeq);
		service.updateDelete(dto);
	}
	
	return "redirect:/productXdmList";
}


//사용자 리스트 목록 화면

@RequestMapping(value = "/productUsrList")
public String productUsrList(@ModelAttribute("vo") ProductVo vo, Model model) throws Exception{

	// 페이징 관련 if 함수 후 모델 객체 불러오기

	// 리스트 페이지 조건에 맞게 호출하기
		vo.setProductCatMainCd(vo.getProductCatMainCd() == null
		    ? null
		    : vo.getProductCatMainCd());
		vo.setProductBestNy(vo.getProductBestNy() == null
		    ? null
		    : vo.getProductBestNy());
		vo.setProductNewNy(vo.getProductNewNy() == null
		    ? null
		    : vo.getProductNewNy());
	
	UtilSearch.setSearch(vo);
	
	vo.setParamsPaging(service.selectOneCountUsr(vo));
		
	if(vo.getTotalRows() > 0) {
		
		model.addAttribute("list", service.selectListUsr(vo));
	}
	
	
	
	return "usr/v1/infra/productUsrList";
}

// 상품 상세 페이지
	@RequestMapping(value = "/productUsrDetail")
	public String productUsrDetail(ProductDto dto, ProductVo vo, FileUploadedVo filevo, ReviewVo rvo, ReviewDto rdto, Model model) throws Exception{
		
		model.addAttribute("item", service.selectOne(dto));
		
		filevo.setFileUploadedFseq(dto.getProductSeq());
		model.addAttribute("fileImg", fileService.selectList(filevo));
		model.addAttribute("listReview", reviewService.selectList(rvo));
		model.addAttribute("reviewCount", reviewService.selectListCount(rvo));
		model.addAttribute("listRelated", service.selectListRelated(vo));
		
		return "usr/v1/infra/productUsrDetail";
	}

// 사용자 인덱스
@RequestMapping(value = "/usrIndex")
public String usrIndex(ProductVo vo, Model model) throws Exception {
	
    model.addAttribute("listBest", service.selectListUsrIndexBest(vo));
    model.addAttribute("listNew", service.selectListUsrIndexNew(vo));
    
    // api 관련
    
    String apiUrl = "https://www.pettravel.kr/api/listPart.do?page=1&pageBlock=16&partCode=PC01";
	
	URL url = new URL(apiUrl);
	HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
	httpURLConnection.setRequestMethod("GET");
	
	BufferedReader bufferedReader;
	if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
		bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
	} else {
		bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
	}
	
	StringBuilder stringBuilder = new StringBuilder();
	String line;
	while ((line = bufferedReader.readLine()) != null) {
		System.out.println("line: " + line);
		stringBuilder.append(line);
	}

	bufferedReader.close();
	httpURLConnection.disconnect();

	ObjectMapper objectMapper = new ObjectMapper();
	JsonNode rootNode = objectMapper.readTree(stringBuilder.toString());
	
	// resultList에 해당하는 JsonNode 가져오기
	JsonNode resultList = rootNode.get(0).get("resultList");
	
	List<PetDto> objectList = new ArrayList<>();
	for (JsonNode node : resultList) {
	    // JSON 데이터를 객체로 변환하여 리스트에 추가
		PetDto obj = objectMapper.treeToValue(node, PetDto.class);
	    objectList.add(obj);
	}
	
	
//	System.out.println("node.get(\"header\").get(\"resultList\").asText(): " + node.get("resultList").get(0).get("areaName").asText());
	
	model.addAttribute("node", objectList);
	
//	model.addAttribute(node);
    
    
    
    return "usr/v1/infra/usrIndex";
}


		

}