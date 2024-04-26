package com.babify.infra.orders;

import java.util.Date;

public class OrdersDto {

	
	private String seq;
	
	private String membersSeq;
	private String membersName;
	private String membersEmail;
	private Integer membersGradeCd;
	
	private String ordersSeq;
	private	Integer ordersDelNy;
	private	Integer ordersUseNy;
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
	private Date ordersRegDate;
	private Date ordersModDate;
	private String membersMembersSeqF;	
	private String ordersOrdersSeqF;
	private String productProductSeqF;
	private String ordersAddressSeq;
	private String addressSeq;
	
	private Integer productOrdersCount;
    private String productSeq;
    private String productName;
    private String addressTitle;
    private Integer addressZipcode;
    private String addressMain;
    private String addressDetail;
    private String addressEtc;
    private String addressName;
    private String addressPhone;

    

	public Integer getAddressZipcode() {
		return addressZipcode;
	}
	public void setAddressZipcode(Integer addressZipcode) {
		this.addressZipcode = addressZipcode;
	}
	public String getAddressMain() {
		return addressMain;
	}
	public void setAddressMain(String addressMain) {
		this.addressMain = addressMain;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getAddressEtc() {
		return addressEtc;
	}
	public void setAddressEtc(String addressEtc) {
		this.addressEtc = addressEtc;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getAddressPhone() {
		return addressPhone;
	}
	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}
	public String getAddressTitle() {
		return addressTitle;
	}
	public void setAddressTitle(String addressTitle) {
		this.addressTitle = addressTitle;
	}
	public Integer getProductOrdersCount() {
		return productOrdersCount;
	}
	public void setProductOrdersCount(Integer productOrdersCount) {
		this.productOrdersCount = productOrdersCount;
	}
	public String getProductSeq() {
		return productSeq;
	}
	public void setProductSeq(String productSeq) {
		this.productSeq = productSeq;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getAddressSeq() {
		return addressSeq;
	}
	public void setAddressSeq(String addressSeq) {
		this.addressSeq = addressSeq;
	}
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
			
	
}
	
	
	
	
	