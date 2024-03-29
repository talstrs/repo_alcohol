package com.babify.infra.members;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babify.common.util.UtilSearch;

import jakarta.servlet.http.HttpSession;

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

	// 관리자 페이지 회원 등록
	@RequestMapping(value = "/membersInsert")
	public String membersInsert(MembersDto dto) throws Exception {


		
		dto.setMembersPw(encodeBcrypt(dto.getMembersPw(), 10));
		
		
		//String encodedPw = dto.getMembersPw();
		
		service.insert(dto);


		return "redirect:/membersXdmList";
	}

	// 사용자 페이지 회원 등록
	@RequestMapping(value = "/membersUsrInsert")
	public String membersUsrInsert(MembersDto dto) throws Exception {


		
		dto.setMembersPw(encodeBcrypt(dto.getMembersPw(), 10));
		
		// String encodedPw = dto.getMembersPw();
		
		service.insert(dto);


		return "redirect:/index";
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
	
	// pw 암호화
	public String encodeBcrypt(String planeText, int strength) {
		
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}


	// pw 복호화	
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}
	
	
	// 관리자 로그인 페이지
	@RequestMapping(value = "/membersXdmLogin")
	public String membersXdmLogin(MembersDto dto) throws Exception {

		return "adm/v1/infra/members/membersXdmLogin";
	}
	
	// 관리자 인덱스
	@RequestMapping(value = "/xdmIndex")
	public String xdmIndex() throws Exception {

		return "adm/v1/infra/stater/xdmIndex";
	}
	
	// 관리자 로그인 체크
	@ResponseBody
	@RequestMapping(value = "signinXdmCheck")
	public Map<String, Object> signinXdmCheck(MembersDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		String loginId = dto.getMembersEmail();
		String loginPw = dto.getMembersPw();
		
		// DB에서 비밀번호 가져오기
	    dto = service.selectOneLoginCheck(dto);
	    String hashedPwFromDB = dto.getMembersPw();
		
		if(matchesBcrypt(loginPw,hashedPwFromDB,10)) {
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "fail");
		}
		
		return returnMap;
	}

	
	// 사용자 로그인 페이지
	@RequestMapping(value = "/membersUsrLogin")
	public String membersUsrLogin(MembersDto dto) throws Exception {

		return "usr/v1/infra/membersUsrLogin";
	}
	
	// 사용자 인덱스
	@RequestMapping(value = "/usrIndex")
	public String usrIndex(MembersDto dto) throws Exception {

		return "usr/v1/infra/usrIndex";
	}
	
	// 사용자 로그인 체크
	@ResponseBody
	@RequestMapping(value = "signinUsrCheck")
	public Map<String, Object> signinUsrCheck(MembersDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		// 아이디, 패스워드를 통해서 회원인지 아닌지 여부 조회

        returnMap.put("rt", "success");
		return returnMap;
	}
	
	

	// 사용자 회원가입
	@RequestMapping(value = "/membersUsrRegister")
	public String membersUsrRegister(MembersDto dto) throws Exception {

		return "usr/v1/infra/membersUsrRegister";
	}
	

}
