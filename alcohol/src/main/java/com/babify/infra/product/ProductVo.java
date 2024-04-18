package com.babify.infra.product;

import com.babify.infra.BaseVo;

public class ProductVo extends BaseVo {
	private String productSeq;
	private String productName;
	private String productInfo;
	private Integer productBestNy;
	private Integer productNewNy;
	private Integer productStock;
	private Double productPrice;
	private Integer productCatMainCd;
	private Integer productCatDetailCd;
	private Integer productStarAll;
	private Integer productSizeCd;
	private Integer productColorCd;
	
	private String[] shCheckboxStarArray  = null; // 별점
	private String[] shCheckboxSizeArray = null; // 사이즈
	private String[] shCheckboxColorArray = null; // 색상
	
	
	
	
	public String[] getShCheckboxSizeArray() {
		return shCheckboxSizeArray;
	}
	public void setShCheckboxSizeArray(String[] shCheckboxSizeArray) {
		this.shCheckboxSizeArray = shCheckboxSizeArray;
	}
	public String[] getShCheckboxColorArray() {
		return shCheckboxColorArray;
	}
	public void setShCheckboxColorArray(String[] shCheckboxColorArray) {
		this.shCheckboxColorArray = shCheckboxColorArray;
	}
	private Integer xReviewStarAvg;
	public String[] getShCheckboxStarArray() {
		return shCheckboxStarArray;
	}
	public void setShCheckboxStarArray(String[] shCheckboxStarArray) {
		this.shCheckboxStarArray = shCheckboxStarArray;
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
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public Integer getProductBestNy() {
		return productBestNy;
	}
	public void setProductBestNy(Integer productBestNy) {
		this.productBestNy = productBestNy;
	}
	public Integer getProductNewNy() {
		return productNewNy;
	}
	public void setProductNewNy(Integer productNewNy) {
		this.productNewNy = productNewNy;
	}
	public Integer getProductStock() {
		return productStock;
	}
	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductCatMainCd() {
		return productCatMainCd;
	}
	public void setProductCatMainCd(Integer productCatMainCd) {
		this.productCatMainCd = productCatMainCd;
	}
	public Integer getProductCatDetailCd() {
		return productCatDetailCd;
	}
	public void setProductCatDetailCd(Integer productCatDetailCd) {
		this.productCatDetailCd = productCatDetailCd;
	}
	public Integer getProductStarAll() {
		return productStarAll;
	}
	public void setProductStarAll(Integer productStarAll) {
		this.productStarAll = productStarAll;
	}
	public Integer getProductSizeCd() {
		return productSizeCd;
	}
	public void setProductSizeCd(Integer productSizeCd) {
		this.productSizeCd = productSizeCd;
	}
	public Integer getProductColorCd() {
		return productColorCd;
	}
	public void setProductColorCd(Integer productColorCd) {
		this.productColorCd = productColorCd;
	}
	public Integer getxReviewStarAvg() {
		return xReviewStarAvg;
	}
	public void setxReviewStarAvg(Integer xReviewStarAvg) {
		this.xReviewStarAvg = xReviewStarAvg;
	}
	
	
	
	
	
	
	
}