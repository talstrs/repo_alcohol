package com.babify.infra.productorders;

import java.util.Date;

public class ProductOrdersVo {
	
	private String productOrdersSeq;
	private Integer productOrdersDelNy;
	private Integer productOrdersCount;
	private Date productOrdersRegDate;
	private Date productOrdersModDate;
	
	private String productSeqF;
	private String ordersSeqF;
	private String productSeq;
	private String ordersSeq;
	public String getProductOrdersSeq() {
		return productOrdersSeq;
	}
	public void setProductOrdersSeq(String productOrdersSeq) {
		this.productOrdersSeq = productOrdersSeq;
	}
	public Integer getProductOrdersDelNy() {
		return productOrdersDelNy;
	}
	public void setProductOrdersDelNy(Integer productOrdersDelNy) {
		this.productOrdersDelNy = productOrdersDelNy;
	}
	public Integer getProductOrdersCount() {
		return productOrdersCount;
	}
	public void setProductOrdersCount(Integer productOrdersCount) {
		this.productOrdersCount = productOrdersCount;
	}
	public Date getProductOrdersRegDate() {
		return productOrdersRegDate;
	}
	public void setProductOrdersRegDate(Date productOrdersRegDate) {
		this.productOrdersRegDate = productOrdersRegDate;
	}
	public Date getProductOrdersModDate() {
		return productOrdersModDate;
	}
	public void setProductOrdersModDate(Date productOrdersModDate) {
		this.productOrdersModDate = productOrdersModDate;
	}
	public String getProductSeqF() {
		return productSeqF;
	}
	public void setProductSeqF(String productSeqF) {
		this.productSeqF = productSeqF;
	}
	public String getOrdersSeqF() {
		return ordersSeqF;
	}
	public void setOrdersSeqF(String ordersSeqF) {
		this.ordersSeqF = ordersSeqF;
	}
	public String getProductSeq() {
		return productSeq;
	}
	public void setProductSeq(String productSeq) {
		this.productSeq = productSeq;
	}
	public String getOrdersSeq() {
		return ordersSeq;
	}
	public void setOrdersSeq(String ordersSeq) {
		this.ordersSeq = ordersSeq;
	}
	
	
}
