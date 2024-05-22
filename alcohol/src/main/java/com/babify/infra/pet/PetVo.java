package com.babify.infra.pet;

import java.util.Date;

import com.babify.infra.BaseVo;

public class PetVo extends BaseVo {
	
	private String petSeq;
	private Integer petDelNy;
	private String petAreaName;
	private String petPartName;
	private String petTitle;
	private String petAddress;
	private Integer petLatitude;
	private Integer petLongitude;
	private String petTel;
	private Date petRegDate;
	private Date petModDate;
	
	
	public String getPetSeq() {
		return petSeq;
	}
	public void setPetSeq(String petSeq) {
		this.petSeq = petSeq;
	}
	public Integer getPetDelNy() {
		return petDelNy;
	}
	public void setPetDelNy(Integer petDelNy) {
		this.petDelNy = petDelNy;
	}
	public String getPetAreaName() {
		return petAreaName;
	}
	public void setPetAreaName(String petAreaName) {
		this.petAreaName = petAreaName;
	}
	public String getPetPartName() {
		return petPartName;
	}
	public void setPetPartName(String petPartName) {
		this.petPartName = petPartName;
	}
	public String getPetTitle() {
		return petTitle;
	}
	public void setPetTitle(String petTitle) {
		this.petTitle = petTitle;
	}
	public String getPetAddress() {
		return petAddress;
	}
	public void setPetAddress(String petAddress) {
		this.petAddress = petAddress;
	}
	public Integer getPetLatitude() {
		return petLatitude;
	}
	public void setPetLatitude(Integer petLatitude) {
		this.petLatitude = petLatitude;
	}
	public Integer getPetLongitude() {
		return petLongitude;
	}
	public void setPetLongitude(Integer petLongitude) {
		this.petLongitude = petLongitude;
	}
	public String getPetTel() {
		return petTel;
	}
	public void setPetTel(String petTel) {
		this.petTel = petTel;
	}
	public Date getPetRegDate() {
		return petRegDate;
	}
	public void setPetRegDate(Date petRegDate) {
		this.petRegDate = petRegDate;
	}
	public Date getPetModDate() {
		return petModDate;
	}
	public void setPetModDate(Date petModDate) {
		this.petModDate = petModDate;
	}
	
	


	
	
	
	
}