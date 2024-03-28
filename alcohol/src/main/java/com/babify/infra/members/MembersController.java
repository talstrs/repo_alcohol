package com.babify.infra.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	public String membersXdmList(@ModelAttribute("vo") MembersVo vo, Model model) throws Exception {

		UtilSearch.setSearch(vo);
		model.addAttribute("list", service.selectList(vo));

		return "adm/v1/infra/members/membersXdmList";
	}

	/* 링크 주소의 html 추가/ 데이터 받기 */
	/* dto로 데이터 정상적으로 넘어오는지 확인하기: codeGroupDto dto 설정 후 sysout으로 확인 */
	@RequestMapping(value = "/membersXdmView")
	public String membersView(MembersDto dto, Model model) throws Exception {

		// 모델로 내용 받았을 경우 html로 넘겨주어야 함
		model.addAttribute("item", service.selectOne(dto));

		return "adm/v1/infra/members/membersXdmView";
	}

	@RequestMapping(value = "/membersXdmEdit")
	public String membersEdit(MembersDto dto, Model model) throws Exception {
		model.addAttribute("item", service.selectOne(dto));
		return "adm/v1/infra/members/membersXdmEdit";
	}

	@RequestMapping(value = "/membersXdmListAdd")
	public String membersXdmListAdd(MembersDto dto) throws Exception {

		return "adm/v1/infra/members/membersXdmListAdd";
	}

	@RequestMapping(value = "/membersInsert")
	public String membersInsert(MembersDto dto) throws Exception {

		service.insert(dto);

		return "redirect:/membersXdmList";
	}

	// 컨트롤러만 리턴 타입을 String으로 변경 가능
	@RequestMapping(value = "/membersUpdt")
	public String membersUpdt(MembersDto dto) throws Exception {
		service.update(dto);

		return "redirect:/membersXdmList";
	}

	@RequestMapping(value = "/membersUele")
	public String membersUele(MembersDto dto) throws Exception {

		service.updateDelete(dto);

		return "redirect:/membersXdmList";
	}

	@RequestMapping(value = "/membersDele")
	public String membersDele(MembersDto dto) throws Exception {

		service.delete(dto);

		return "redirect:/membersXdmList";
	}
	
	// 이후 로그인 부분 비밀번호 비교
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

			
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}
	
	// 이후 로그인 부분 비밀번호 비교 적용 예시
//	System.out.println("dto.getIfmmId(): " + dto.getIfmmId());
//	
//	dto.setIfmmId(encodeBcrypt(dto.getIfmmId(), 10));
//	String encodedId = dto.getIfmmId();
//	
//	System.out.println("dto.getIfmmId()encoded: " + dto.getIfmmId());
//	
//	System.out.println("---------------------");
//	
//	System.out.println("dto.getIfmmName(): " + dto.getIfmmName());
//	
//	String name = dto.getIfmmName();
//	dto.setIfmmName(encodeBcrypt(dto.getIfmmName(),9));
//	
//	System.out.println("dto.getIfmmName().encoded: " + dto.getIfmmName());
//	
//	System.out.println("---------------------");
//	
//	if(dto.getIfmmId().equals(dto.getIfmmName())) {
//		System.out.println("true");
//	} else {
//		System.out.println("false");
//	}
//	
//	System.out.println("---------------------");
//	
//	if(matchesBcrypt(name, dto.getIfmmId(),10)) {
//		System.out.println("true");
//	} else {
//		System.out.println("false");
//	}
//	
//	System.out.println("###########################");	

}
