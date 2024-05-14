package com.babify.infra.product;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.babify.common.base.BaseDto;

public class ProductDto extends BaseDto {
	
	
	private String productSeq;
	private	Integer productDelNy;
	private	Integer productUseNy;
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
	private Date productRegDate;
	private Date productModDate;
	
	private Integer xReviewStarAvg;
	private Integer xReviewSrarAvgAll;
	
	private Integer minPrice;
	private Integer maxPrice;
	
	private String[] checkboxSeqArray  = null;
	
	private MultipartFile uploadFile;
	private MultipartFile[] uploadFiles;
	
	
	

	
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	public String[] getCheckboxSeqArray() {
		return checkboxSeqArray;
	}
	public void setCheckboxSeqArray(String[] checkboxSeqArray) {
		this.checkboxSeqArray = checkboxSeqArray;
	}
	public Integer getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}
	public Integer getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Integer getxReviewSrarAvgAll() {
		return xReviewSrarAvgAll;
	}
	public void setxReviewSrarAvgAll(Integer xReviewSrarAvgAll) {
		this.xReviewSrarAvgAll = xReviewSrarAvgAll;
	}
	public String getProductSeq() {
		return productSeq;
	}
	public void setProductSeq(String productSeq) {
		this.productSeq = productSeq;
	}
	public Integer getProductDelNy() {
		return productDelNy;
	}
	public void setProductDelNy(Integer productDelNy) {
		this.productDelNy = productDelNy;
	}
	public Integer getProductUseNy() {
		return productUseNy;
	}
	public void setProductUseNy(Integer productUseNy) {
		this.productUseNy = productUseNy;
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
	public Date getProductRegDate() {
		return productRegDate;
	}
	public void setProductRegDate(Date productRegDate) {
		this.productRegDate = productRegDate;
	}
	public Date getProductModDate() {
		return productModDate;
	}
	public void setProductModDate(Date productModDate) {
		this.productModDate = productModDate;
	}
	public Integer getxReviewStarAvg() {
		return xReviewStarAvg;
	}
	public void setxReviewStarAvg(Integer xReviewStarAvg) {
		this.xReviewStarAvg = xReviewStarAvg;
	}
	
	
	
	
	
	
	
	

	

	
}
	
	
	
	
	