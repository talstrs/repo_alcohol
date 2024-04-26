package com.babify.infra.orders;

import java.util.Date;

import com.babify.infra.BaseVo;

public class OrdersVo extends BaseVo {

	private String membersSeq;
	private String membersName;
	private String membersEmail;
	private Integer membersGradeCd;
	
	private String ordersSeq;
	private	Integer ordersStatusCd;
	private	Integer ordersPaymentCd;
	private	Integer ordersCardCompanyCd;
	private	String ordersCardNo;
	private String ordersName;
	private	Integer ordersCardDate;
	private	Integer ordersCardCvv;	
	private	Integer ordersFeeNy;
	private	Double ordersPrice;	
	private Double ordersTotalPrice;
	private String membersMembersSeqF;
	private String ordersOrdersSeqF;
	private String productProductSeqF;
	private String ordersAddressSeq;
	
	
	// 추후 VO로 진행
	private	Integer ordersDelNy;
	private	Integer ordersUseNy;
	private Date ordersRegDate;
	private Date ordersModDate;
	public String getMembersSeq() {
		return membersSeq;
	}
	public void setMembersSeq(String membersSeq) {
		this.membersSeq = membersSeq;
	}
	public String getMembersName() {
		return membersName;
	}
	public void setMembersName(String membersName) {
		this.membersName = membersName;
	}
	public String getMembersEmail() {
		return membersEmail;
	}
	public void setMembersEmail(String membersEmail) {
		this.membersEmail = membersEmail;
	}
	public Integer getMembersGradeCd() {
		return membersGradeCd;
	}
	public void setMembersGradeCd(Integer membersGradeCd) {
		this.membersGradeCd = membersGradeCd;
	}
	public String getOrdersSeq() {
		return ordersSeq;
	}
	public void setOrdersSeq(String ordersSeq) {
		this.ordersSeq = ordersSeq;
	}
	public Integer getOrdersStatusCd() {
		return ordersStatusCd;
	}
	public void setOrdersStatusCd(Integer ordersStatusCd) {
		this.ordersStatusCd = ordersStatusCd;
	}
	public Integer getOrdersPaymentCd() {
		return ordersPaymentCd;
	}
	public void setOrdersPaymentCd(Integer ordersPaymentCd) {
		this.ordersPaymentCd = ordersPaymentCd;
	}
	public Integer getOrdersCardCompanyCd() {
		return ordersCardCompanyCd;
	}
	public void setOrdersCardCompanyCd(Integer ordersCardCompanyCd) {
		this.ordersCardCompanyCd = ordersCardCompanyCd;
	}
	public String getOrdersCardNo() {
		return ordersCardNo;
	}
	public void setOrdersCardNo(String ordersCardNo) {
		this.ordersCardNo = ordersCardNo;
	}
	public String getOrdersName() {
		return ordersName;
	}
	public void setOrdersName(String ordersName) {
		this.ordersName = ordersName;
	}
	public Integer getOrdersCardDate() {
		return ordersCardDate;
	}
	public void setOrdersCardDate(Integer ordersCardDate) {
		this.ordersCardDate = ordersCardDate;
	}
	public Integer getOrdersCardCvv() {
		return ordersCardCvv;
	}
	public void setOrdersCardCvv(Integer ordersCardCvv) {
		this.ordersCardCvv = ordersCardCvv;
	}
	public Integer getOrdersFeeNy() {
		return ordersFeeNy;
	}
	public void setOrdersFeeNy(Integer ordersFeeNy) {
		this.ordersFeeNy = ordersFeeNy;
	}
	public Double getOrdersPrice() {
		return ordersPrice;
	}
	public void setOrdersPrice(Double ordersPrice) {
		this.ordersPrice = ordersPrice;
	}
	public Double getOrdersTotalPrice() {
		return ordersTotalPrice;
	}
	public void setOrdersTotalPrice(Double ordersTotalPrice) {
		this.ordersTotalPrice = ordersTotalPrice;
	}
	public String getMembersMembersSeqF() {
		return membersMembersSeqF;
	}
	public void setMembersMembersSeqF(String membersMembersSeqF) {
		this.membersMembersSeqF = membersMembersSeqF;
	}
	public String getOrdersOrdersSeqF() {
		return ordersOrdersSeqF;
	}
	public void setOrdersOrdersSeqF(String ordersOrdersSeqF) {
		this.ordersOrdersSeqF = ordersOrdersSeqF;
	}
	public String getProductProductSeqF() {
		return productProductSeqF;
	}
	public void setProductProductSeqF(String productProductSeqF) {
		this.productProductSeqF = productProductSeqF;
	}
	public String getOrdersAddressSeq() {
		return ordersAddressSeq;
	}
	public void setOrdersAddressSeq(String ordersAddressSeq) {
		this.ordersAddressSeq = ordersAddressSeq;
	}
	public Integer getOrdersDelNy() {
		return ordersDelNy;
	}
	public void setOrdersDelNy(Integer ordersDelNy) {
		this.ordersDelNy = ordersDelNy;
	}
	public Integer getOrdersUseNy() {
		return ordersUseNy;
	}
	public void setOrdersUseNy(Integer ordersUseNy) {
		this.ordersUseNy = ordersUseNy;
	}
	public Date getOrdersRegDate() {
		return ordersRegDate;
	}
	public void setOrdersRegDate(Date ordersRegDate) {
		this.ordersRegDate = ordersRegDate;
	}
	public Date getOrdersModDate() {
		return ordersModDate;
	}
	public void setOrdersModDate(Date ordersModDate) {
		this.ordersModDate = ordersModDate;
	}
			
	
}