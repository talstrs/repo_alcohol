package com.babify.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService service;

	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupXdmList(CodeGroupVo vo, Model model) throws Exception{
		
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
		
		
		// 받아오자마자 바로 넘기는 방법
		model.addAttribute("list", service.selectList(vo));
//		list = codeGroupDtos;
		
		// vo라는 이름으로 객체를 넘겨야 오류가 나지 않음
		model.addAttribute("vo", vo);
		
		System.out.println(vo.toString());
	
	return  "adm/v1/infra/codegroup/codeGroupXdmList";
}
	
/* 링크 주소의 html 추가/ 데이터 받기 */
/* dto로 데이터 정상적으로 넘어오는지 확인하기: codeGroupDto dto 설정 후 sysout으로 확인 */
@RequestMapping(value = "/codeGroupXdmView")
public String codeGroupView(CodeGroupDto dto, Model model) throws Exception{

//	넘긴 데이터: 해당 링크 클릭시 콘솔 창에 해당 데이터 값 확인
//	but, dto 이름과 동일하게 설정해야 함
	System.out.println("dto.getSeq(): " + dto.getSeq());
	System.out.println("dto.getName(): " + dto.getName());
	
//	넘기지 않은 데이터: 해당 링크 클릭스 콘솔 창에 null 값으로 확인
	System.out.println("dto.getModDatetime(): " + dto.getModDatetime());
	
	// 모델로 내용 받았을 경우 html로 넘겨주어야 함
	model.addAttribute("item", service.selectOne(dto));
	
	return "adm/v1/infra/codegroup/codeGroupXdmView";
}

@RequestMapping(value = "/codeGroupXdmEdit")
public String codeGroupEdit(CodeGroupDto dto, Model model) throws Exception{

	// 값이 실제로 넘어오는지 콘솔창으로 확인하기
	System.out.println("dto.getSeq(): " + dto.getSeq());
	
	// 모델로 내용 받았을 경우 html로 넘겨주어야 함
	// addAttribute = 함수
	// addAttribute("변수명", 값(객체));
	model.addAttribute("item", service.selectOne(dto));
	
	
	return "adm/v1/infra/codegroup/codeGroupXdmEdit";
}

@RequestMapping(value = "/codeGroupXdmListAdd")
public String codeGroupXdmListAdd(CodeGroupDto dto) throws Exception{
	
	
	return "adm/v1/infra/codegroup/codeGroupXdmListAdd";
}

@RequestMapping(value = "/codeGroupInsert")
// 컨트롤러만 리턴 타입을 String으로 변경 가능
public String codeGroupInsert(CodeGroupDto dto) throws Exception{
	
	System.out.println("dto.getName(): " + dto.getName());
	System.out.println("dto.getMemo(): " + dto.getMemo());
	
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
	
	System.out.println("dto.getName(): " + dto.getName());
	
	service.update(dto);
	
//	return "codeGroupXdmListAdd";
	// 보여지는 화면을 만들기 위하여 리턴값으로 redirect를 사용하여 노출
	// redirect:/파일명
	// 해당 리퀘스트매핑 페이지로 가라는 내용
	return "redirect:/codeGroupXdmList";
}

@RequestMapping(value = "/codeGroupUele")
public String codeGroupUele(CodeGroupDto dto) throws Exception{
	
	System.out.println("dto.getSeq(): " + dto.getSeq());
	System.out.println(dto.toString());
	service.updateDelete(dto);
	
	return "redirect:/codeGroupXdmList";
}

@RequestMapping(value = "/codeGroupDele")
public String codeGroupDele(CodeGroupDto dto) throws Exception{
	
	System.out.println("dto.getSeq(): " + dto.getSeq());
	System.out.println(dto.toString());
	service.delete(dto);
	
	return "redirect:/codeGroupXdmList";
}
		

}
