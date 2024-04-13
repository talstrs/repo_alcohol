package com.babify.infra.review;

import java.util.Date;

import com.babify.infra.BaseVo;

public class ReviewVo extends BaseVo {

	private String reviewSeq;
	private	String reviewText;
	private	Integer reviewStarCd;
	private String productSeq;	
	private String reviewMembersSeq;
	
	private Integer membersSeq;
	private String membersName;
	
	private Integer xReviewStarAvg;
	
	
	// 추후 VO로 진행
	private	Integer reviewDelNy;
	private	Integer reviewUseNy;
	private Date reviewRegDate;
	private Date reviewModDate;
	public String getReviewSeq() {
		return reviewSeq;
	}
	public void setReviewSeq(String reviewSeq) {
		this.reviewSeq = reviewSeq;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public Integer getReviewStarCd() {
		return reviewStarCd;
	}
	public void setReviewStarCd(Integer reviewStarCd) {
		this.reviewStarCd = reviewStarCd;
	}
	public String getProductSeq() {
		return productSeq;
	}
	public void setProductSeq(String productSeq) {
		this.productSeq = productSeq;
	}
	public String getReviewMembersSeq() {
		return reviewMembersSeq;
	}
	public void setReviewMembersSeq(String reviewMembersSeq) {
		this.reviewMembersSeq = reviewMembersSeq;
	}
	public Integer getMembersSeq() {
		return membersSeq;
	}
	public void setMembersSeq(Integer membersSeq) {
		this.membersSeq = membersSeq;
	}
	public String getMembersName() {
		return membersName;
	}
	public void setMembersName(String membersName) {
		this.membersName = membersName;
	}
	public Integer getxReviewStarAvg() {
		return xReviewStarAvg;
	}
	public void setxReviewStarAvg(Integer xReviewStarAvg) {
		this.xReviewStarAvg = xReviewStarAvg;
	}
	public Integer getReviewDelNy() {
		return reviewDelNy;
	}
	public void setReviewDelNy(Integer reviewDelNy) {
		this.reviewDelNy = reviewDelNy;
	}
	public Integer getReviewUseNy() {
		return reviewUseNy;
	}
	public void setReviewUseNy(Integer reviewUseNy) {
		this.reviewUseNy = reviewUseNy;
	}
	public Date getReviewRegDate() {
		return reviewRegDate;
	}
	public void setReviewRegDate(Date reviewRegDate) {
		this.reviewRegDate = reviewRegDate;
	}
	public Date getReviewModDate() {
		return reviewModDate;
	}
	public void setReviewModDate(Date reviewModDate) {
		this.reviewModDate = reviewModDate;
	}
	
	
	
}