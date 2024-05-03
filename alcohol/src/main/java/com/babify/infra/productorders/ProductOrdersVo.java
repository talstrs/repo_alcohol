package com.babify.infra.productorders;

import java.util.Date;

public class ProductOrdersVo {
	
	private String productordersSeq;
	private Integer productordersDelNy;
	private Integer productordersCount;
	private Date productordersRegDate;
	private Date productordersModDate;
	
	private String productSeqF;
	private String ordersSeqF;
	private String productSeq;
	private String ordersSeq;
	
	public String getProductOrdersSeq() {
		return productordersSeq;
	}
	public void setProductOrdersSeq(String productOrdersSeq) {
		this.productordersSeq = productOrdersSeq;
	}
	public Integer getProductOrdersDelNy() {
		return productordersDelNy;
	}
	public void setProductOrdersDelNy(Integer productOrdersDelNy) {
		this.productordersDelNy = productOrdersDelNy;
	}
	public Integer getProductOrdersCount() {
		return productordersCount;
	}
	public void setProductOrdersCount(Integer productOrdersCount) {
		this.productordersCount = productOrdersCount;
	}
	public Date getProductOrdersRegDate() {
		return productordersRegDate;
	}
	public void setProductOrdersRegDate(Date productOrdersRegDate) {
		this.productordersRegDate = productOrdersRegDate;
	}
	public Date getProductOrdersModDate() {
		return productordersModDate;
	}
	public void setProductOrdersModDate(Date productOrdersModDate) {
		this.productordersModDate = productOrdersModDate;
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
