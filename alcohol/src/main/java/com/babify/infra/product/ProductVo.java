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
	
	private String codeSeq;
	private String codeName;
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
	public String getCodeSeq() {
		return codeSeq;
	}
	public void setCodeSeq(String codeSeq) {
		this.codeSeq = codeSeq;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	@Override
	public String toString() {
		return "ProductVo [productSeq=" + productSeq + ", productName=" + productName + ", productInfo=" + productInfo
				+ ", productBestNy=" + productBestNy + ", productNewNy=" + productNewNy + ", productStock="
				+ productStock + ", productPrice=" + productPrice + ", productCatMainCd=" + productCatMainCd
				+ ", productCatDetailCd=" + productCatDetailCd + ", productStarAll=" + productStarAll
				+ ", productSizeCd=" + productSizeCd + ", productColorCd=" + productColorCd + ", codeSeq=" + codeSeq
				+ ", codeName=" + codeName + "]";
	}
	

	
	
	
	







	
	
	
	
}
