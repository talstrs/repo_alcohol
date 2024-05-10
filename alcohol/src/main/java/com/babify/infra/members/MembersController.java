package com.babify.infra.members;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babify.common.constants.Constants;
import com.babify.common.util.UtilSearch;
import com.babify.infra.mail.MailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MembersController {

	@Autowired
	MembersService service;
		
	@Autowired
	MailService mailService;
	
	@Value("${javascript_key}")
	private String javascriptKey;

	@Value("${kakao_rest_key}")
	private String kakaoRestKey;
	
	@Value("${kakao_redirect_uri}")
	private String kakaoRedirectUri;
	
	@Value("${kakao_location}")
	private String location;	
	

	@RequestMapping(value = "/membersXdmList")
	public String membersXdmList(@ModelAttribute("vo") MembersVo vo, Model model) throws Exception {

		UtilSearch.setSearch(vo);
		
		// 페이징 관련 if 함수 후 모델 객체 불러오기
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if(vo.getTotalRows() > 0) {
			
			model.addAttribute("list", service.selectList(vo));
		}
		

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
	public String membersXdmListAdd() throws Exception {

		return "adm/v1/infra/members/membersXdmListAdd";
	}

	// 관리자 페이지 회원 등록
	@RequestMapping(value = "/membersInsert")
	public String membersInsert(MembersDto dto) throws Exception {


		
		dto.setMembersPw(encodeBcrypt((String) dto.getMembersPw(), 10));
		
		service.insert(dto);


		return "redirect:/membersXdmList";
	}

	// 사용자 페이지 회원 등록
	@RequestMapping(value = "/membersUsrInsert")
	public String membersUsrInsert(MembersDto dto) throws Exception {


		
		dto.setMembersPw(encodeBcrypt((String) dto.getMembersPw(), 10));
		
		
		service.insert(dto);
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				mailService.sendMailSimple(dto);
			}
		});
		
		thread.start();


		return "redirect:/usrIndex";
	}
	
	
	// 컨트롤러만 리턴 타입을 String으로 변경 가능
	@RequestMapping(value = "/membersUpdt")
	public String membersUpdt(MembersDto dto) throws Exception {
		
		dto.setMembersPw(encodeBcrypt((String) dto.getMembersPw(), 10));
		
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
	
	// 멀티 체크박스 삭제
	@RequestMapping(value = "/membersMultiUele")
	public String membersMultiUele(MembersDto dto) throws Exception{
		String[] checkboxSeqArray = dto.getCheckboxSeqArray();
		for(String checkboxSeq : checkboxSeqArray) {
			dto.setMembersSeq(checkboxSeq);
			service.updateDelete(dto);
		}
		
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
	public String membersXdmLogin() throws Exception {

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

		// DB에서 데이터 가져오기
		MembersDto dtoCheck = service.selectOneLoginCheck(dto);
		
		
		
		
		if(dtoCheck != null) {
			
			String checkPw = dtoCheck.getMembersPw();
			String loginId = dto.getMembersEmail();
			String loginPw = dto.getMembersPw();
			Integer checkAdminNy = dtoCheck.getMembersAdminNy();
			
			
				
			httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqXdm", dtoCheck.getMembersSeq());
			httpSession.setAttribute("sessIdXdm", dtoCheck.getMembersEmail());
			httpSession.setAttribute("sessNameXdm", dtoCheck.getMembersName());
			
			if(loginId.equals(dtoCheck.getMembersEmail()) && checkAdminNy == 1) {
				if(matchesBcrypt(loginPw , checkPw ,10)) {
					returnMap.put("rt", "success");
				} else {
					returnMap.put("rt", "failPw");
				}
			} else {
				returnMap.put("rt", "failId");
			}
		} else {
			returnMap.put("rt", "failId");
		}
		return returnMap;
	}
	
	// 관리자 세션 로그아웃
	@ResponseBody
	@RequestMapping(value = "signOutXdmCheck")
	public Map<String, Object> signOutXdmCheck(MembersDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		httpSession.invalidate(); // 세션 무효화
		
		returnMap.put("rt", "success");
		
        return returnMap; // 로그아웃 후 관리자 로그인 페이지로 리다이렉트
    }

	
	// 사용자 로그인 페이지
	@RequestMapping(value = "/membersUsrLogin")
	public String membersUsrLogin(Model model) throws Exception {
		
    	String location = "https://kauth.kakao.com/oauth/authorize?client_id="+kakaoRestKey+"&redirect_uri="+kakaoRedirectUri+"&response_type=code&scope=account_email";
//    	String location = "https://kauth.kakao.com/oauth/authorize?client_id="+kakaoRestKey+"&redirect_uri="+kakaoRedirectUri+"&response_type=code&scope=account_email,name,gender,phone_number";
    	model.addAttribute("location", location);
    	model.addAttribute("javascriptKey", javascriptKey);
    	model.addAttribute("kakaoRestKey", kakaoRestKey);
    	model.addAttribute("kakaoRedirectUri", kakaoRedirectUri);

		return "usr/v1/infra/membersUsrLogin";
	}
	
	
	// 카카오 로그인 리다이렉트
    @RequestMapping(value="/redirectKakao")
    public String loginKakaoRedirect(MembersDto dto, Model model, HttpSession httpSession) throws Exception {
    	System.out.println("dto.getCode()================"+dto.getCode());
		
    	// 토큰 받기 
    	String accessToken = service.getAccessTokenFromKakao(kakaoRestKey, dto.getCode());
		
    	dto = service.getUserInfo(accessToken, dto);
		  
    	
    	System.out.println(dto.getEmail());
    	System.out.println("-----------------------------------");
//    	MembersDto membersDto = service.kakaoSelectOne(dto);
    	
    	
     // 회원존재확인
    	if(service.kakaoSelectOne(dto) != null) {
    		// by pass 
    	} else {
    		service.kakaoinsert(dto);
    	}
    	
    	MembersDto rtLogin = service.kakaoSelectOne(dto);
    	
    	httpSession.setAttribute("sessSeqUsr", rtLogin.getMembersSeq());
    	httpSession.setAttribute("sessNameUsr", rtLogin.getMembersName());
    	
        
        model.addAttribute("info", dto);
        
        return "usr/v1/infra/usrIndex";
    }

	
	// 사용자 로그인 체크
	@ResponseBody
	@RequestMapping(value = "signinUsrCheck")
	public Map<String, Object> signinUsrCheck(MembersDto dto, HttpSession httpSession) throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();

		// DB에서 데이터 가져오기
		MembersDto dtoCheck = service.selectOneLoginCheck(dto);
		
		
		
		
		if(dtoCheck != null) {
			
			String checkPw = dtoCheck.getMembersPw();
			String loginId = dto.getMembersEmail();
			String loginPw = dto.getMembersPw();
			Integer checkAdminNy = dtoCheck.getMembersAdminNy();
			
			
				
			httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqUsr", dtoCheck.getMembersSeq());
			httpSession.setAttribute("sessIdUsr", dtoCheck.getMembersEmail());
			httpSession.setAttribute("sessNameUsr", dtoCheck.getMembersName());
			
			if(loginId.equals(dtoCheck.getMembersEmail()) && checkAdminNy == 0) {
				if(matchesBcrypt(loginPw , checkPw ,10)) {
					returnMap.put("rt", "success");
				} else {
					returnMap.put("rt", "failPw");
				}
			} else {
				returnMap.put("rt", "failId");
			}
		} else {
			returnMap.put("rt", "failId");
		}
		return returnMap;
	}
	
	

	// 사용자 회원가입 페이지
	@RequestMapping(value = "/membersUsrRegister")
	public String membersUsrRegister(MembersDto dto) throws Exception {

		return "usr/v1/infra/membersUsrRegister";
	}
	
	// 사용자 세션 로그아웃
	@ResponseBody
	@RequestMapping(value = "signOutUsrCheck")
	public Map<String, Object> signOutUsrCheck(MembersDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		httpSession.invalidate(); // 세션 무효화
		
		returnMap.put("rt", "success");
		
        return returnMap; // 로그아웃 후 관리자 로그인 페이지로 리다이렉트
    }
	

}
