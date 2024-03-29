package com.babify.infra.members;

import com.babify.infra.BaseVo;

public class MembersVo extends BaseVo {
	private String membersSeq;
	private String membersEmail;
	private String membersPw;
	private String membersName;
	private String membersBirth;
	private Integer membersGenderCd;
	private Integer membersGradeCd;
	private Integer membersAdminNy;
	
	private String codeName;
	private String codeSeq;
	public String getMembersSeq() {
		return membersSeq;
	}
	public void setMembersSeq(String membersSeq) {
		this.membersSeq = membersSeq;
	}
	public String getMembersEmail() {
		return membersEmail;
	}
	public void setMembersEmail(String membersEmail) {
		this.membersEmail = membersEmail;
	}
	public String getMembersPw() {
		return membersPw;
	}
	public void setMembersPw(String membersPw) {
		this.membersPw = membersPw;
	}
	public String getMembersName() {
		return membersName;
	}
	public void setMembersName(String membersName) {
		this.membersName = membersName;
	}
	public String getMembersBirth() {
		return membersBirth;
	}
	public void setMembersBirth(String membersBirth) {
		this.membersBirth = membersBirth;
	}
	public Integer getMembersGenderCd() {
		return membersGenderCd;
	}
	public void setMembersGenderCd(Integer membersGenderCd) {
		this.membersGenderCd = membersGenderCd;
	}
	public Integer getMembersGradeCd() {
		return membersGradeCd;
	}
	public void setMembersGradeCd(Integer membersGradeCd) {
		this.membersGradeCd = membersGradeCd;
	}
	public Integer getMembersAdminNy() {
		return membersAdminNy;
	}
	public void setMembersAdminNy(Integer membersAdminNy) {
		this.membersAdminNy = membersAdminNy;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getCodeSeq() {
		return codeSeq;
	}
	public void setCodeSeq(String codeSeq) {
		this.codeSeq = codeSeq;
	}
	@Override
	public String toString() {
		return "MembersVo [membersSeq=" + membersSeq + ", membersEmail=" + membersEmail + ", membersPw=" + membersPw
				+ ", membersName=" + membersName + ", membersBirth=" + membersBirth + ", membersGenderCd="
				+ membersGenderCd + ", membersGradeCd=" + membersGradeCd + ", membersAdminNy=" + membersAdminNy
				+ ", codeName=" + codeName + ", codeSeq=" + codeSeq + "]";
	}
	
	
	
	
	
	
	
	
	







	
	
	
	
}