package com.babify.infra.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;


@Service
public class CodeService {

	@Autowired
	CodeDao dao;
	
	@PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) dao.selectListCachedCodeArrayList();
//		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		CodeDto.cachedCodeArrayList.clear(); 
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
	}
	
	
	public List<CodeDto> selectList(CodeVo vo) {
		return dao.selectList(vo);
	}
	
	public CodeDto selectOne(CodeDto dto) {
		return dao.selectOne(dto);
	}
	
	public int insert(CodeDto dto) {
		return dao.insert(dto);
	}
	
	public int update(CodeDto dto) {
		return dao.update(dto);
	}
	
	public int updateDelete(CodeDto dto) {
		return dao.updateDelete(dto);
	}
	public int delete(CodeDto dto) {
		return dao.delete(dto);
	}
	
	// code cache 관련
	public static String selectOneCachedCode(int code) throws Exception {
		String rt = "";
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCodeSeq().equals(Integer.toString(code))) {
				rt = codeRow.getCodeName();
			} else {
				// by pass
			}
		}
		return rt;
	}
	
	// codeGroup - code list cache 관련
	public static List<CodeDto> selectListCachedCode(String codeGroupSeq) throws Exception {
		System.out.println("codeGroupSeq: " + codeGroupSeq);
		List<CodeDto> rt = new ArrayList<CodeDto>();
		
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			System.out.println(codeRow.getCodeSeq() + codeGroupSeq);
			if (codeRow.getCodeGroupSeqF().equals(codeGroupSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}
}
