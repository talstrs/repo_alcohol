package com.babify.infra.code;

import com.babify.infra.BaseVo;

public class CodeVo extends BaseVo {
	

	
	private String seq;
	private String codeGroupSeq;
	private String codeGroupName;
	private Integer codeGroupSeqF;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
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
	public Integer getCodeGroupSeqF() {
		return codeGroupSeqF;
	}
	public void setCodeGroupSeqF(Integer codeGroupSeqF) {
		this.codeGroupSeqF = codeGroupSeqF;
	}
	@Override
	public String toString() {
		return "CodeVo [seq=" + seq + ", codeGroupSeq=" + codeGroupSeq + ", codeGroupName=" + codeGroupName
				+ ", codeGroupSeqF=" + codeGroupSeqF + "]";
	}
	
	
	
	

	
	
	

}
