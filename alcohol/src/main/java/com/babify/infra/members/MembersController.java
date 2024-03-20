package com.babify.infra.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.babify.common.util.UtilSearch;


@Controller
public class MembersController {
	
	@Autowired
	MembersService service;

	
	@RequestMapping(value = "/membersXdmList")
	public String membersXdmList(@ModelAttribute("vo") MembersVo vo, Model model) throws Exception{
		
		UtilSearch.setSearch(vo);
		
		model.addAttribute("list", service.selectList(vo));

		
		System.out.println(vo.toString());
	
	return  "adm/v1/infra/members/membersXdmList";
}
	
/* 링크 주소의 html 추가/ 데이터 받기 */
/* dto로 데이터 정상적으로 넘어오는지 확인하기: codeGroupDto dto 설정 후 sysout으로 확인 */
@RequestMapping(value = "/membersXdmView")
public String membersView(MembersDto dto, Model model) throws Exception{

	
	// 모델로 내용 받았을 경우 html로 넘겨주어야 함
	model.addAttribute("item", service.selectOne(dto));
	
	return "adm/v1/infra/members/membersXdmView";
}

@RequestMapping(value = "/membersXdmEdit")
public String membersEdit(MembersDto dto, Model model) throws Exception{

	model.addAttribute("item", service.selectOne(dto));
	
	
	return "adm/v1/infra/members/membersXdmEdit";
}

@RequestMapping(value = "/membersXdmListAdd")
public String membersXdmListAdd(MembersDto dto) throws Exception{
	
	
	return "adm/v1/infra/members/membersXdmListAdd";
}

@RequestMapping(value = "/membersInsert")
// 컨트롤러만 리턴 타입을 String으로 변경 가능
public String membersInsert(MembersDto dto) throws Exception{

	
	service.insert(dto);
	
	return "redirect:/membersXdmList";
}

@RequestMapping(value = "/membersUpdt")
// 컨트롤러만 리턴 타입을 String으로 변경 가능
public String membersUpdt(MembersDto dto) throws Exception{

	
	service.update(dto);
	

	return "redirect:/membersXdmList";
}

@RequestMapping(value = "/membersUele")
public String membersUele(MembersDto dto) throws Exception{
	
	System.out.println(dto.toString());
	service.updateDelete(dto);
	
	return "redirect:/membersXdmList";
}

@RequestMapping(value = "/membersDele")
public String membersDele(MembersDto dto) throws Exception{

	System.out.println(dto.toString());
	service.delete(dto);
	
	return "redirect:/membersXdmList";
}




		

}
