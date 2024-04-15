package com.babify.infra.wishlist;

import java.util.Date;

public class WishlistVo  {

	private String wishListSeq;

	private	String membersSeq;
	private	String productSeq;
	
	
	// 추후 VO로 진행
	private	Integer wishListDelNy;
	private	Integer wishListUseNy;
	private Date wishListRegDate;
	private Date wishListModDate;
	
	public String getWishListSeq() {
		return wishListSeq;
	}
	public void setWishListSeq(String wishListSeq) {
		this.wishListSeq = wishListSeq;
	}
	public String getMembersSeq() {
		return membersSeq;
	}
	public void setMembersSeq(String membersSeq) {
		this.membersSeq = membersSeq;
	}
	public String getProductSeq() {
		return productSeq;
	}
	public void setProductSeq(String productSeq) {
		this.productSeq = productSeq;
	}
	public Integer getWishListDelNy() {
		return wishListDelNy;
	}
	public void setWishListDelNy(Integer wishListDelNy) {
		this.wishListDelNy = wishListDelNy;
	}
	public Integer getWishListUseNy() {
		return wishListUseNy;
	}
	public void setWishListUseNy(Integer wishListUseNy) {
		this.wishListUseNy = wishListUseNy;
	}
	public Date getWishListRegDate() {
		return wishListRegDate;
	}
	public void setWishListRegDate(Date wishListRegDate) {
		this.wishListRegDate = wishListRegDate;
	}
	public Date getWishListModDate() {
		return wishListModDate;
	}
	public void setWishListModDate(Date wishListModDate) {
		this.wishListModDate = wishListModDate;
	}
	
	
	
}