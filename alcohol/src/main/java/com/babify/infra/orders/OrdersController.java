package com.babify.infra.orders;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babify.infra.address.AddressDto;
import com.babify.infra.address.AddressService;
import com.babify.infra.address.AddressVo;
import com.babify.infra.members.MembersDto;
import com.babify.infra.members.MembersService;

import jakarta.servlet.http.HttpSession;


@Controller
public class OrdersController {
	
	@Autowired
	OrdersService service;
	
	@Autowired
	MembersService membersService;
	

	@Autowired
	AddressService addressService;
	
	// 마이페이지 페이지
	@RequestMapping(value = "/myAccount")
	public String myAccount(@ModelAttribute("vo") OrdersVo vo, AddressVo advo, MembersDto mdto, Model model, HttpSession httpSession) throws Exception{
		
		
		mdto.setMembersSeq((String) httpSession.getAttribute("sessSeqUsr"));	
		model.addAttribute("item", membersService.selectOne(mdto));

		advo.setMembersMembersSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("listAddress", addressService.selectList(advo));
		
		vo.setMembersMembersSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("list", service.selectList(vo));
		

			
		
		return  "usr/v1/infra/myAccount";
	}
	
	// 개인정보 수정 페이지
	@RequestMapping(value = "/myAccountMembersEdit")
	public String myAccountMembersEdit(MembersDto mdto,  Model model, HttpSession httpSession) throws Exception{

		mdto.setMembersSeq((String) httpSession.getAttribute("sessSeqUsr"));
		
		
		model.addAttribute("item", membersService.selectOne(mdto));
		
		return  "usr/v1/infra/myAccountEdit";
	}
	
	// 개인정보 수정
	@RequestMapping(value = "/myAccountMembersUpdt")
	public String membersUpdt(MembersDto mdto, HttpSession httpSession) throws Exception {
		

		
		mdto.setMembersSeq((String) httpSession.getAttribute("sessSeqUsr"));
		

//		mdto.setMembersPw(encodeBcrypt((String) mdto.getMembersPw(), 10));
		
		
		membersService.updateUsr(mdto);

		return "redirect:/myAccount";
	}
	
	// 개인정보 수정(비밀번호) 페이지
	@RequestMapping(value = "/myAccountPwEdit")
	public String myAccountPwEdit(MembersDto mdto,  Model model, HttpSession httpSession) throws Exception{

		mdto.setMembersSeq((String) httpSession.getAttribute("sessSeqUsr"));
		
		
		model.addAttribute("item", membersService.selectOne(mdto));
		
		return  "usr/v1/infra/myAccountPwEdit";
	}
	
	// 개인정보 수정(비밀번호)
	
	@ResponseBody
	@RequestMapping(value = "/pwdUpdate")
	public Map<String, Object> pwdUpdate(OrdersDto dto, MembersDto mdto , HttpSession httpSession,Model model) throws Exception {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			
			mdto.setMembersSeq((String)httpSession.getAttribute("sessSeqUsr"));
			
			
			
			// DB에서 데이터 가져오기
			MembersDto dtoCheck = membersService.selectOnePw(mdto);
			
			
			
			
			if(dtoCheck != null) {
				
			
				if(matchesBcrypt(mdto.getxMembersBeforePw(), dtoCheck.getMembersPw(),10) )  {
					if(mdto.getMembersPw().equals(mdto.getxMembersNewPwCheck()) ) {
						mdto.setMembersPw(encodeBcrypt(mdto.getMembersPw(), 10));
						membersService.updateUsrPw(mdto);
						returnMap.put("rt", "success");
					} else {
						returnMap.put("rt", "fail");
					}
					
				} else {
					returnMap.put("rt", "fail");
				}
			} else {
				returnMap.put("rt", "fail");
			}
		
			
			return returnMap;

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
	
	// 오더 상세페이지 페이지 myAccountOrderView
	@RequestMapping(value = "/myAccountOrderView")
	public String myAccountOrderView(OrdersDto dto, MembersDto mdto, AddressDto addto,  Model model, HttpSession httpSession) throws Exception{

		mdto.setMembersSeq((String) httpSession.getAttribute("sessSeqUsr"));
		
		model.addAttribute("itemMembers", membersService.selectOne(mdto));
		
		model.addAttribute("item", service.selectOne(dto));
		
		addto.setAddressSeq((String) dto.getOrdersAddressSeq());

		model.addAttribute("itemAddress", addressService.selectOne(addto));
		
		return  "usr/v1/infra/myAccountOrderView";
	}
	
	// 결제 페이지
	@RequestMapping(value = "/checkOut")
	public String checkOut( AddressVo avo, AddressDto adto,  Model model,HttpSession httpSession) throws Exception{
		
		// 어드레스 셀렉문
		avo.setMembersMembersSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("listAddress", addressService.selectList(avo));
		
		
		
		
		
		return  "usr/v1/infra/checkOut";
	}
	
	// 결제 페이지 셀렉문 아작스
	@ResponseBody
	@RequestMapping(value = "addressSelectCheck")
	public Map<String, Object> addressSelectCheck(AddressDto adto, Model model, HttpSession httpSession) throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();

		
		
		// DB에서 데이터 가져오기
		System.out.println("adto.getAddressSeq() : " + adto.getAddressSeq());
		System.out.println("addressService.selectOne(adto).getAddressSeq();: " + addressService.selectOne(adto).getAddressSeq());
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
				
		if(adto.getAddressSeq() != null) {
			
		       // 주소 데이터를 Map에 담아 JSON으로 전달
	        Map<String, Object> addressMap = new HashMap<>();
	        AddressDto addressDto = addressService.selectOne(adto);
	        addressMap.put("addressSeq", addressDto.getAddressSeq());
	        addressMap.put("addressZipcode", addressDto.getAddressZipcode());
	        addressMap.put("addressMain", addressDto.getAddressMain());
	        addressMap.put("addressDetail", addressDto.getAddressDetail());
	        addressMap.put("addressEtc", addressDto.getAddressEtc());
	        addressMap.put("addressName", addressDto.getAddressName());
	        addressMap.put("addressPhone", addressDto.getAddressPhone());
	        
	        // returnMap에도 성공 여부와 함께 데이터를 담아 전달
	        returnMap.put("rt", "success");
	        returnMap.put("itemAddress", addressMap);
			
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	
	// 결제 등록
	@RequestMapping(value = "/checkOutInsert")
	public String checkOutInsert(OrdersDto dto,  Model model, HttpSession httpSession) throws Exception{

		service.insert(dto);
		
		return  "usr/v1/infra/myAccount";
	}
		

}