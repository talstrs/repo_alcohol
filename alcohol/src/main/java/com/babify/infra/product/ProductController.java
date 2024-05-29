package com.babify.infra.product;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.babify.common.util.UtilDateTime;
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

import jakarta.servlet.http.HttpServletResponse;


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
    
    String apiUrl = "https://www.pettravel.kr/api/listPart.do?page=1&pageBlock=12&partCode=PC01";
	
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
		// 내용 확인 주석
//		System.out.println("line: " + line);
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


// 관리자 List 엑셀 다운로드
@RequestMapping("excelDownloadProduct")
public void excelDownloadProduct(ProductVo vo, HttpServletResponse httpServletResponse) throws Exception {
	
	UtilSearch.setSearch(vo);
	vo.setParamsPaging(service.selectOneCount(vo));

	if (vo.getTotalRows() > 0) {
		List<ProductDto> list = service.selectList(vo);
		
//		Workbook workbook = new HSSFWorkbook();	// for xls
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("시트 1");
        CellStyle cellStyle = workbook.createCellStyle();        
        Row row = null;
        Cell cell = null;
        int rowNum = 0;
		
//        each column width setting
        sheet.setColumnWidth(0, 2100);
        sheet.setColumnWidth(1, 3100);

//        Header
        String[] tableHeader = {"삭제 여부", "상품 번호", "베스트 여부", "새상품 여부", "상품 이름", "재고 수", "가격", "카테고리(메인)", "카테고리(세부)", "사이즈", "색상", "등록일", "수정일"};

        row = sheet.createRow(rowNum++);
		for(int i=0; i<tableHeader.length; i++) {
			cell = row.createCell(i);
        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
        	cell.setCellStyle(cellStyle);
			cell.setCellValue(tableHeader[i]);
		}

//        Body
        for (int i=0; i<list.size(); i++) {
            row = sheet.createRow(rowNum++);
            
//            String type: null 전달 되어도 ok
//            int, date type: null 시 오류 발생 하므로 null check
//            String type 이지만 정수형 데이터가 전체인 seq 의 경우 캐스팅
            
            cell = row.createCell(0);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(cellStyle);
            if(list.get(i).getProductDelNy() != null) cell.setCellValue(list.get(i).getProductDelNy() == 0 ? "N" : "Y");
            
            cell = row.createCell(1);
        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
        	cell.setCellStyle(cellStyle);
            cell.setCellValue(Integer.parseInt(list.get(i).getProductSeq()));
            
            cell = row.createCell(2);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(cellStyle);
            if(list.get(i).getProductBestNy() != null) cell.setCellValue(list.get(i).getProductBestNy() == 0 ? "N" : "Y");
            
            cell = row.createCell(3);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(cellStyle);
            if(list.get(i).getProductNewNy() != null) cell.setCellValue(list.get(i).getProductNewNy() == 0 ? "N" : "Y");
            
            cell = row.createCell(4);
        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
        	cell.setCellStyle(cellStyle);
        	cell.setCellValue(list.get(i).getProductName());
        	
            cell = row.createCell(5);
        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
        	cell.setCellStyle(cellStyle);
        	cell.setCellValue(list.get(i).getProductStock());
        	
            cell = row.createCell(6);
        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
        	cell.setCellStyle(cellStyle);
        	cell.setCellValue(list.get(i).getProductPrice());
            
            cell = row.createCell(7);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(cellStyle);
            if(list.get(i).getProductCatMainCd() != null) {
            	if(list.get(i).getProductCatMainCd() == 12) {cell.setCellValue("Chothing");}
            	else if(list.get(i).getProductCatMainCd() == 13) {cell.setCellValue("Toys");}
            	else if(list.get(i).getProductCatMainCd() == 14) {cell.setCellValue("Feed");}
            	else if(list.get(i).getProductCatMainCd() == 15) {cell.setCellValue("Accessories");}
            	else if(list.get(i).getProductCatMainCd() == 16) {cell.setCellValue("Learning");}
            }
            
            cell = row.createCell(8);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(cellStyle);
            if(list.get(i).getProductCatDetailCd() != null) {
            	if(list.get(i).getProductCatDetailCd() == 17) {cell.setCellValue("tShirt");} 
            	else if(list.get(i).getProductCatDetailCd() == 18) {cell.setCellValue("outer");}
            	else if(list.get(i).getProductCatDetailCd() == 19) {cell.setCellValue("onePiece");}
            	else if(list.get(i).getProductCatDetailCd() == 20) {cell.setCellValue("allInOne");}
            	else if(list.get(i).getProductCatDetailCd() == 21) {cell.setCellValue("seasonClothing");}
            	else if(list.get(i).getProductCatDetailCd() == 22) {cell.setCellValue("shoes");}
            	else if(list.get(i).getProductCatDetailCd() == 23) {cell.setCellValue("ChothingEtc");}
            	else if(list.get(i).getProductCatDetailCd() == 24) {cell.setCellValue("fabric");}
            	else if(list.get(i).getProductCatDetailCd() == 25) {cell.setCellValue("ball");}
            	else if(list.get(i).getProductCatDetailCd() == 26) {cell.setCellValue("tug");}
            	else if(list.get(i).getProductCatDetailCd() == 27) {cell.setCellValue("ToysEtc");}
            	else if(list.get(i).getProductCatDetailCd() == 28) {cell.setCellValue("dry");}
            	else if(list.get(i).getProductCatDetailCd() == 29) {cell.setCellValue("soft");}
            	else if(list.get(i).getProductCatDetailCd() == 30) {cell.setCellValue("wet");}
            	else if(list.get(i).getProductCatDetailCd() == 31) {cell.setCellValue("raw");}
            	else if(list.get(i).getProductCatDetailCd() == 32) {cell.setCellValue("frozen");}
            	else if(list.get(i).getProductCatDetailCd() == 33) {cell.setCellValue("FeedEtc");}
            	else if(list.get(i).getProductCatDetailCd() == 34) {cell.setCellValue("movingBag");}
            	else if(list.get(i).getProductCatDetailCd() == 35) {cell.setCellValue("kennel");}
            	else if(list.get(i).getProductCatDetailCd() == 36) {cell.setCellValue("carSeat");}
            	else if(list.get(i).getProductCatDetailCd() == 37) {cell.setCellValue("stroller");}
            	else if(list.get(i).getProductCatDetailCd() == 38) {cell.setCellValue("AccessoriesEtc");}
            	else if(list.get(i).getProductCatDetailCd() == 39) {cell.setCellValue("noseWalk");}
            }
 
            cell = row.createCell(9);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(cellStyle);
            if(list.get(i).getProductSizeCd() != null) {
            	if(list.get(i).getProductSizeCd() == 55) {cell.setCellValue("XS");}
            	else if(list.get(i).getProductSizeCd() == 56) {cell.setCellValue("S");}
            	else if(list.get(i).getProductSizeCd() == 57) {cell.setCellValue("M");}
            	else if(list.get(i).getProductSizeCd() == 58) {cell.setCellValue("L");}
            	else if(list.get(i).getProductSizeCd() == 59) {cell.setCellValue("XL");}
            }
            
            cell = row.createCell(10);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(cellStyle);
            if(list.get(i).getProductColorCd() != null) {
            	if(list.get(i).getProductColorCd() == 60) {cell.setCellValue("BLUE");}
            	else if(list.get(i).getProductColorCd() == 62) {cell.setCellValue("GREEN");}
            	else if(list.get(i).getProductColorCd() == 63) {cell.setCellValue("RED");}
            }
            
            cell = row.createCell(11);
        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
        	cell.setCellStyle(cellStyle);
        	if(list.get(i).getProductRegDate() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getProductRegDate()));
            
        	cell = row.createCell(12);
        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
        	cell.setCellStyle(cellStyle);
        	if(list.get(i).getProductModDate() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getProductModDate()));
        }

        httpServletResponse.setContentType("ms-vnd/excel");
//        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xls");	// for xls
        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

        workbook.write(httpServletResponse.getOutputStream());
        workbook.close();
	}
}

		

}