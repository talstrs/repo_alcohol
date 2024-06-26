package com.babify.infra.members;

import java.util.Date;

import com.babify.infra.kakaologin.KakaoLoginDto;

public class MembersDto extends KakaoLoginDto {
	
	private String membersSeq;
	private Integer membersDelNy;
	private Integer membersUseNy;
	private String membersEmail;
	private String membersPw;
	private String membersName;
	private String membersBirth;
	private Integer membersGenderCd;
	private Integer membersGradeCd;
	private Date membersRegDate;
	private Date membersModDate;
	private Integer membersAdminNy;
	
	private	String xMembersBeforePw;
	private String xMembersNewPwCheck;
	
	private String email;
	private String name;
	
	private String[] checkboxSeqArray  = null;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getCheckboxSeqArray() {
		return checkboxSeqArray;
	}
	public void setCheckboxSeqArray(String[] checkboxSeqArray) {
		this.checkboxSeqArray = checkboxSeqArray;
	}
	public String getMembersSeq() {
		return membersSeq;
	}
	public void setMembersSeq(String membersSeq) {
		this.membersSeq = membersSeq;
	}
	public Integer getMembersDelNy() {
		return membersDelNy;
	}
	public void setMembersDelNy(Integer membersDelNy) {
		this.membersDelNy = membersDelNy;
	}
	public Integer getMembersUseNy() {
		return membersUseNy;
	}
	public void setMembersUseNy(Integer membersUseNy) {
		this.membersUseNy = membersUseNy;
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
	public Date getMembersRegDate() {
		return membersRegDate;
	}
	public void setMembersRegDate(Date membersRegDate) {
		this.membersRegDate = membersRegDate;
	}
	public Date getMembersModDate() {
		return membersModDate;
	}
	public void setMembersModDate(Date membersModDate) {
		this.membersModDate = membersModDate;
	}
	public Integer getMembersAdminNy() {
		return membersAdminNy;
	}
	public void setMembersAdminNy(Integer membersAdminNy) {
		this.membersAdminNy = membersAdminNy;
	}
	public String getxMembersBeforePw() {
		return xMembersBeforePw;
	}
	public void setxMembersBeforePw(String xMembersBeforePw) {
		this.xMembersBeforePw = xMembersBeforePw;
	}
	public String getxMembersNewPwCheck() {
		return xMembersNewPwCheck;
	}
	public void setxMembersNewPwCheck(String xMembersNewPwCheck) {
		this.xMembersNewPwCheck = xMembersNewPwCheck;
	}
		
	
}
	
	
	
	
	