package com.babify.infra.code;

import com.babify.infra.BaseVo;

public class CodeVo extends BaseVo {
	

	
	private String codeSeq;
	private String codeGroupSeq;
	private String codeGroupName;
	private String codeGroupSeqF;

	public String getCodeSeq() {
		return codeSeq;
	}
	public void setCodeSeq(String codeSeq) {
		this.codeSeq = codeSeq;
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
	public String getCodeGroupSeqF() {
		return codeGroupSeqF;
	}
	public void setCodeGroupSeqF(String codeGroupSeqF) {
		this.codeGroupSeqF = codeGroupSeqF;
	}
	@Override
	public String toString() {
		return "CodeVo [codeSeq=" + codeSeq + ", codeGroupSeq=" + codeGroupSeq + ", codeGroupName=" + codeGroupName
				+ ", codeGroupSeqF=" + codeGroupSeqF + "]";
	}

	
	
	
	
	

	
	
	

}
