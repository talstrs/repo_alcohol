package com.babify.infra.code;

import java.util.Date;

public class CodeDto {
	
	private String codeSeq;
	private String codeName;
	private String codeMemo;
	private Integer codeDelNy;
	private Date codeRegDatetime;
	private Date codeModDatetime;
	private Integer codeGroupSeqF;
	private String codeGroupSeq;
	private String codeGroupName;
	
	public String getCodeSeq() {
		return codeSeq;
	}
	public void setCodeSeq(String codeSeq) {
		this.codeSeq = codeSeq;
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
	public Integer getCodeDelNy() {
		return codeDelNy;
	}
	public void setCodeDelNy(Integer codeDelNy) {
		this.codeDelNy = codeDelNy;
	}
	public Date getCodeRegDatetime() {
		return codeRegDatetime;
	}
	public void setCodeRegDatetime(Date codeRegDatetime) {
		this.codeRegDatetime = codeRegDatetime;
	}
	public Date getCodeModDatetime() {
		return codeModDatetime;
	}
	public void setCodeModDatetime(Date codeModDatetime) {
		this.codeModDatetime = codeModDatetime;
	}
	public Integer getCodeGroupSeqF() {
		return codeGroupSeqF;
	}
	public void setCodeGroupSeqF(Integer codeGroupSeqF) {
		this.codeGroupSeqF = codeGroupSeqF;
	}
	public String getCodeGroupSeq() {
		return codeGroupSeq;
	}
	public void setCodeGroupSeq(String codeGroupSeq) {
		this.codeGroupSeq = codeGroupSeq;
	}
	public String getCodeGroupName() {
		return codeGroupName;
	}
	public void setCodeGroupName(String codeGroupName) {
		this.codeGroupName = codeGroupName;
	}
	
	@Override
	public String toString() {
		return "CodeDto [codeSeq=" + codeSeq + ", codeName=" + codeName + ", codeMemo=" + codeMemo + ", codeDelNy="
				+ codeDelNy + ", codeRegDatetime=" + codeRegDatetime + ", codeModDatetime=" + codeModDatetime
				+ ", codeGroupSeqF=" + codeGroupSeqF + ", codeGroupSeq=" + codeGroupSeq + ", codeGroupName="
				+ codeGroupName + "]";
	}



	
	
}