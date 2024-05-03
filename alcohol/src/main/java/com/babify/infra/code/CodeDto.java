package com.babify.infra.code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CodeDto {

	private String codeSeq;
	private Integer codeDelNy;
	private Integer codeUseNy;
	private String codeName;
	private String codeMemo;

	private Date codeRegDate;
	private Date codeModDate;
	private String codegroupSeqF;
	private String codegroupSeq;
	private String codegroupName;

//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();

	// for dto

	public String getCodeSeq() {
		return codeSeq;
	}

	public void setCodeSeq(String codeSeq) {
		this.codeSeq = codeSeq;
	}

	public Integer getCodeDelNy() {
		return codeDelNy;
	}

	public void setCodeDelNy(Integer codeDelNy) {
		this.codeDelNy = codeDelNy;
	}

	public Integer getCodeUseNy() {
		return codeUseNy;
	}

	public void setCodeUseNy(Integer codeUseNy) {
		this.codeUseNy = codeUseNy;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeMemo() {
		return codeMemo;
	}

	public void setCodeMemo(String codeMemo) {
		this.codeMemo = codeMemo;
	}

	public Date getCodeRegDate() {
		return codeRegDate;
	}

	public void setCodeRegDate(Date codeRegDate) {
		this.codeRegDate = codeRegDate;
	}

	public Date getCodeModDate() {
		return codeModDate;
	}

	public void setCodeModDate(Date codeModDate) {
		this.codeModDate = codeModDate;
	}

	public String getCodeGroupSeqF() {
		return codegroupSeqF;
	}

	public void setCodeGroupSeqF(String codeGroupSeqF) {
		this.codegroupSeqF = codeGroupSeqF;
	}

	public String getCodeGroupSeq() {
		return codegroupSeq;
	}

	public void setCodeGroupSeq(String codeGroupSeq) {
		this.codegroupSeq = codeGroupSeq;
	}

	public String getCodeGroupName() {
		return codegroupName;
	}

	public void setCodeGroupName(String codeGroupName) {
		this.codegroupName = codeGroupName;
	}

	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}

	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}


}