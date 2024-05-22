package com.babify.infra.pet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/pet")
public class PetController {

	@Autowired
	PetService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<PetDto> pet(PetVo vo, Model model) throws Exception{
		
		List<PetDto> list = service.selectList(vo);
		
		return list;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public PetDto petInsert(PetDto dto) throws Exception{

		service.insert(dto);
		
		return dto;
	}
	
	@RequestMapping(value = "/{seq}", method = RequestMethod.PUT)
	public String petUpte(@PathVariable String seq, PetDto dto) throws Exception{
		
		dto.setPetSeq(seq);
		
		service.update(dto);
		
		return dto.getPetSeq();
	}
	
	@RequestMapping(value = "/petUele")
	public String petUele(PetDto dto) throws Exception{
		
		service.updateDelete(dto);
		
		return "redirect:/usrIndex";
	}
	
	@RequestMapping(value = "/petDele")
	public String petDele(PetDto dto) throws Exception{
		
		service.delete(dto);
		
		return "redirect:/usrIndex";
	}
		

}
