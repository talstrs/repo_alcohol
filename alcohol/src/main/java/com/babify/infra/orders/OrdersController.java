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
import com.babify.infra.product.ProductDto;
import com.babify.infra.product.ProductService;
import com.babify.infra.productorders.ProductOrdersDto;
import com.babify.infra.productorders.ProductOrdersService;

import jakarta.servlet.http.HttpSession;


@Controller
public class OrdersController {
	
	@Autowired
	OrdersService service;
	
	@Autowired
	MembersService membersService;
	

	@Autowired
	AddressService addressService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductOrdersService productOrdersService;
	
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
		

		
		return  "usr/v1/infra/myAccountOrderView";
	}
	
	// 결제 페이지
	@RequestMapping(value = "/checkOut")
	public String checkOut( AddressVo avo, AddressDto adto, ProductDto pdto,  Model model,HttpSession httpSession) throws Exception{
		
		// 어드레스 셀렉문
		avo.setMembersMembersSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("listAddress", addressService.selectList(avo));
		
		model.addAttribute("itemProduct", productService.selectOne(pdto));
		
		
		
		return  "usr/v1/infra/checkOut";
	}
	
	// 결제 페이지 셀렉문 아작스
	@ResponseBody
	@RequestMapping(value = "addressSelectCheck")
	public Map<String, Object> addressSelectCheck(AddressDto adto, Model model, HttpSession httpSession) throws Exception {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
				
		if(adto.getAddressSeq() != null) {
				        
	        // returnMap에도 성공 여부와 함께 데이터를 담아 전달
	        returnMap.put("rt", "success");
	        returnMap.put("itemAddress", addressService.selectOne(adto));
			
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	
	// 결제 등록
	@RequestMapping(value = "/checkOutInsert")
	public String checkOutInsert(OrdersDto dto, ProductOrdersDto podto,  Model model, HttpSession httpSession) throws Exception{

		dto.setMembersMembersSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		service.insert(dto);
		
		podto.setOrdersSeq(dto.getSeq());
		
		productOrdersService.insert(podto);
		
		return "redirect:/myAccount";
		
	}
	
	// 오더 율리트
	@RequestMapping(value = "/ordersUele")
	public String ordersUele(OrdersDto dto) throws Exception{
		
		service.updateDelete(dto);
		
		return "redirect:/myAccount";
	}
		

}