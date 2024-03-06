package com.babify.infra.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

	@Autowired
	CodeService service;
	
	@RequestMapping(value = "/codeXdmList")
	public String codeXdmList(Model model) throws Exception{
		
		model.addAttribute("list", service.selectList());
		
		System.out.println("--------------");
		System.out.println(model.toString());
		
		return "codeXdmList";
	}
	
	@RequestMapping(value = "/codeView")
	public String codeView(CodeDto dto, Model model) throws Exception{
		
		System.out.println("dto.getCodeSeq(): " + dto.getCodeSeq());
		System.out.println("dto.getCodeName(): " + dto.getCodeName());
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "codeView";
	}
	
	@RequestMapping(value = "/codeEdit")
	public String codeEdit(CodeDto dto, Model model) throws Exception{
		
		System.out.println("dto.getCodeSeq(): " + dto.getCodeSeq());
		System.out.println("dto.getCodeName(): " + dto.getCodeName());
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "codeEdit";
	}
	
	@RequestMapping(value = "/codeXdmListAdd")
	public String codeXdmListAdd(CodeDto dto) throws Exception{
		
		
		return "codeXdmListAdd";
	}
	
	@RequestMapping(value = "/codeInsert")
	public String codeInsert(CodeDto dto) throws Exception{
		
		System.out.println("dto.getCodeMemo(): " + dto.getCodeMemo());
		System.out.println("dto.getCodeName(): " + dto.getCodeName());
		
		service.insert(dto);
		
		return "redirect:/codeXdmList";
	}
	
	@RequestMapping(value = "/codeUpdt")
	public String codeUpdt(CodeDto dto) throws Exception{
		
		System.out.println("dto.getCodeSeq(): " + dto.getCodeSeq());
		System.out.println("dto.getCodeName(): " + dto.getCodeName());
		
		service.update(dto);
		
		return "redirect:/codeXdmList";
	}
	
	@RequestMapping(value = "/codeDtOne")
	public String codeDtOne(CodeDto dto) throws Exception{
		
		System.out.println("dto.getCodeSeq(): " + dto.getCodeSeq());
		
		service.updateDelete(dto);
		
		return "redirect:/codeXdmList";
	}
	
	@RequestMapping(value = "/codeDtTwo")
	public String codeDtTwo(CodeDto dto) throws Exception{
		

		service.delete(dto);
		
		return "redirect:/codeXdmList";
	}
}
