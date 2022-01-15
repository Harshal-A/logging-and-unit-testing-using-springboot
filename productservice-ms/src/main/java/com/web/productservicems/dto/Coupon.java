package com.web.productservicems.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

public class Coupon {
private Long id;
	
	
	private String code;
	
	
	private BigDecimal discount;
	
	
	private String expDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getcode() {
		return code;
	}
	public void setcode(String code) {
		this.code = code;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	
	
}
