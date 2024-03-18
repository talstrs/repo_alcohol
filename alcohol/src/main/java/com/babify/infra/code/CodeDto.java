package com.babify.infra.code;

import java.util.Date;

public class CodeDto {
	
	private String codeSeq;
	private Integer codeDelNy;
	private Integer codeUseNy;
	private String codeName;
	private String codeMemo;

	private Date codeRegDate;
	private Date codeModDate;
	private Integer codeGroupSeqF;
	private String codeGroupSeq;
	private String codeGroupName;
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
		return "CodeDto [codeSeq=" + codeSeq + ", codeDelNy=" + codeDelNy + ", codeUseNy=" + codeUseNy + ", codeName="
				+ codeName + ", codeMemo=" + codeMemo + ", codeRegDate=" + codeRegDate + ", codeModDate=" + codeModDate
				+ ", codeGroupSeqF=" + codeGroupSeqF + ", codeGroupSeq=" + codeGroupSeq + ", codeGroupName="
				+ codeGroupName + "]";
	}
	
	
	



	
	
}