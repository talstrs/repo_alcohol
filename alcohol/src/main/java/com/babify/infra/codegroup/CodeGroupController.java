package com.babify.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.babify.common.util.UtilSearch;


@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService service;

	
	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{
		
		UtilSearch.setSearch(vo);
		
		// 받아와서 클래스를 만들고
//		List<CodeGroupDto> codeGroupDtos = service.selectList();
		
		// model: 컨트롤러에서 받은 객체를 html로 넘겨주는 역할을 담당하며 하나의 객체, DB가 담기는 그릇
		// 만든 내용에 대해 넘기기
//		model.addAttribute("list", codeGroupDtos);
		
		
		// for문은 해당 데이터가 정상적으로 보여지는지 개발자가 확인하는 구문
//		for(CodeGroupDto a: codeGroupDtos) {
//			System.out.println(a.getName());
//		}
//		
		
		
		// 페이징 관련 if 함수 후 모델 객체 불러오기
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if(vo.getTotalRows() > 0) {
			
			model.addAttribute("list", service.selectList(vo));
		}
//		list = codeGroupDtos;
		
		// modelAttrubute("vo") -> 가져온 vo 내용을 바로 html 페이지로 보내는 방법으로 해당 바업 사용시 모델.addAtrribute는 주석처리
		// vo라는 이름으로 객체를 넘겨야 오류가 나지 않음
//		model.addAttribute("vo", vo);
		
		System.out.println(vo.toString());
	
	return  "adm/v1/infra/codegroup/codeGroupXdmList";
}
	
/* 링크 주소의 html 추가/ 데이터 받기 */
/* dto로 데이터 정상적으로 넘어오는지 확인하기: codeGroupDto dto 설정 후 sysout으로 확인 */
@RequestMapping(value = "/codeGroupXdmView")
public String codeGroupView(CodeGroupDto dto, Model model) throws Exception{

//	넘긴 데이터: 해당 링크 클릭시 콘솔 창에 해당 데이터 값 확인
//	but, dto 이름과 동일하게 설정해야 함
	System.out.println("dto.getCodeGroupSeq(): " + dto.getCodeGroupSeq());
	System.out.println("dto.getCodeGroupName(): " + dto.getCodeGroupName());
	
//	넘기지 않은 데이터: 해당 링크 클릭스 콘솔 창에 null 값으로 확인
	System.out.println("dto.getCodeGroupModDate(): " + dto.getCodeGroupModDate());
	
	// 모델로 내용 받았을 경우 html로 넘겨주어야 함
	model.addAttribute("item", service.selectOne(dto));
	
	return "adm/v1/infra/codegroup/codeGroupXdmView";
}

@RequestMapping(value = "/codeGroupXdmEdit")
public String codeGroupEdit(CodeGroupDto dto, Model model) throws Exception{

	// 값이 실제로 넘어오는지 콘솔창으로 확인하기
	System.out.println("dto.getCodeGroupSeq(): " + dto.getCodeGroupSeq());
	
	// 모델로 내용 받았을 경우 html로 넘겨주어야 함
	// addAttribute = 함수
	// addAttribute("변수명", 값(객체));
	model.addAttribute("item", service.selectOne(dto));
	
	
	return "adm/v1/infra/codegroup/codeGroupXdmEdit";
}

@RequestMapping(value = "/codeGroupXdmListAdd")
public String codeGroupXdmListAdd() throws Exception{
	
	
	return "adm/v1/infra/codegroup/codeGroupXdmListAdd";
}

@RequestMapping(value = "/codeGroupInsert")
// 컨트롤러만 리턴 타입을 String으로 변경 가능
public String codeGroupInsert(CodeGroupDto dto) throws Exception{
	
	System.out.println("dto.getCodeGroupName(): " + dto.getCodeGroupName());
	System.out.println("dto.getCodeGroupMemo(): " + dto.getCodeGroupMemo());
	
	service.insert(dto);
	
//	return "codeGroupXdmListAdd";
	// 보여지는 화면을 만들기 위하여 리턴값으로 redirect를 사용하여 노출
	// redirect:/파일명
	// 해당 리퀘스트매핑 페이지로 가라는 내용
	return "redirect:/codeGroupXdmList";
}

@RequestMapping(value = "/codeGroupUpdt")
// 컨트롤러만 리턴 타입을 String으로 변경 가능
public String codeGroupUpdt(CodeGroupDto dto) throws Exception{
	
	System.out.println("dto.getCodeGroupName(): " + dto.getCodeGroupName());
	
	service.update(dto);
	
//	return "codeGroupXdmListAdd";
	// 보여지는 화면을 만들기 위하여 리턴값으로 redirect를 사용하여 노출
	// redirect:/파일명
	// 해당 리퀘스트매핑 페이지로 가라는 내용
	return "redirect:/codeGroupXdmList";
}

@RequestMapping(value = "/codeGroupUele")
public String codeGroupUele(CodeGroupDto dto) throws Exception{
	
	System.out.println("dto.getCodeGroupSeq(): " + dto.getCodeGroupSeq());
	System.out.println(dto.toString());
	service.updateDelete(dto);
	
	return "redirect:/codeGroupXdmList";
}

@RequestMapping(value = "/codeGroupDele")
public String codeGroupDele(CodeGroupDto dto) throws Exception{
	
	System.out.println("dto.getCodeGroupSeq(): " + dto.getCodeGroupSeq());
	System.out.println(dto.toString());
	service.delete(dto);
	
	return "redirect:/codeGroupXdmList";
}

// 멀티 체크박스 삭제
@RequestMapping(value = "/codeGroupMultiUele")
public String codeGroupMultiUele(CodeGroupDto dto) throws Exception{
	
	String[] checkboxSeqArray = dto.getCheckboxSeqArray();
	
	for(String checkboxSeq : checkboxSeqArray) {
		
		dto.setCodeGroupSeq(checkboxSeq);
		
		service.updateDelete(dto);
	}
	
	return "redirect:/codeGroupXdmList";
}




		

}
